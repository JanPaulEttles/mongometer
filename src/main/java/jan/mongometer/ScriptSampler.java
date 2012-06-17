package jan.mongometer;

import java.util.Arrays;

import org.apache.jmeter.engine.event.LoopIterationEvent;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestListener;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 17/06/12
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class ScriptSampler
    extends AbstractSampler
        implements TestBean, TestListener {

    private static final long serialVersionUID = -678108159079724396L;

    private static final Logger log = LoggingManager.getLoggerForClass();

    public final static String SCRIPT = "ScriptSampler.script"; //$NON-NLS-1$
    public final static String CONNECTION = "ScriptSampler.connection"; //$NON-NLS-1$
    public final static String DATABASE = "ScriptSampler.database"; //$NON-NLS-1$
    public final static String USERNAME = "ScriptSampler.username"; //$NON-NLS-1$
    public final static String PASSWORD = "ScriptSampler.password"; //$NON-NLS-1$
    public final static String CONNECTIONS_PER_HOST = "ScriptSampler.connectionsPerHost"; //$NON-NLS-1$
    public final static String THREADS_ALLOWED = "ScriptSampler.threadsAllowedToBlockForConnectionMultiplier"; //$NON-NLS-1$

    public static MongoDB m;

    private static int classCount = 0; // keep track of classes created

    public ScriptSampler() {
        classCount++;
        trace("ScriptSampler()");
    }

    public SampleResult sample(Entry e) {
        trace("sample()");

        SampleResult res = new SampleResult();
        String data = getScript();
        String response = null;

        res.setSampleLabel(getTitle());
        res.sampleStart();
        try {

            m.evaluate(getScript());

            response = Thread.currentThread().getName();
            res.setSamplerData(data);
            res.setResponseData(response.getBytes());
            res.setDataType(SampleResult.TEXT);

            res.setResponseCodeOK();
            res.setResponseCode("200");
            res.setSuccessful(true);
            res.setResponseMessage("OK");// $NON-NLS-1$
        }
        catch (Exception ex) {
            log.warn("", ex);
            res.setResponseCode("500");// $NON-NLS-1$
            res.setSuccessful(false);
            res.setResponseMessage(ex.toString());
        }
        finally {
            res.sampleEnd();
        }

        return res;
    }

    private String getTitle() {
        return this.getName();
    }

    public String getScript() {
        return getPropertyAsString(SCRIPT);
    }

    public void setScript(String script) {
        setProperty(SCRIPT, script);
    }

    public String getConnection() {
        return getPropertyAsString(CONNECTION);
    }

    public void setConnection(String connection) {
        setProperty(CONNECTION, connection);
    }

    public String getConnectionsPerHost() {
        return getPropertyAsString(CONNECTIONS_PER_HOST);
    }

    public void setConnectionsPerHost(String connectionsPerHost) {
        setProperty(CONNECTIONS_PER_HOST, connectionsPerHost);
    }

    public String getThreadsAllowedToBlockForConnectionMultiplier() {
        return getPropertyAsString(THREADS_ALLOWED);
    }

    public void setThreadsAllowedToBlockForConnectionMultiplier(String threadsAllowed) {
        setProperty(THREADS_ALLOWED, threadsAllowed);
    }

    public String getDatabase() {
        return getPropertyAsString(DATABASE);
    }

    public void setDatabase(String database) {
        setProperty(DATABASE, database);
    }

    public String getUsername() {
        return getPropertyAsString(USERNAME);
    }

    public void setUsername(String username) {
        setProperty(USERNAME, username);
    }

    public String getPassword() {
        return getPropertyAsString(PASSWORD);
    }

    public void setPassword(String password) {
        setProperty(PASSWORD, password);
    }

    /*
    * Helper
    */
    private void trace(String s) {
        String tl = getTitle();
        String tn = Thread.currentThread().getName();
        String th = this.toString();
        log.debug(tn + " (" + classCount + ") " + tl + " " + s + " " + th);
    }

    @Override
    public void testIterationStart(LoopIterationEvent arg0) {
        if(log.isDebugEnabled()) {
            log.debug("testIterationStart : " + arg0);
        }
    }

    @Override
    public void testStarted() {
        testStarted("");
    }

    @Override
    public void testStarted(String arg0) {
        if(log.isDebugEnabled()) {
            log.debug("testStarted : " + arg0);
        }
        m = new MongoDB(Arrays.asList(getConnection().split("\\s*,\\s*")),
                getDatabase(),
                Integer.parseInt(getConnectionsPerHost()),
                Integer.parseInt(getThreadsAllowedToBlockForConnectionMultiplier()),
                getUsername(),
                getPassword());
    }


    @Override
    public void testEnded() {
        testEnded("");
    }

    @Override
    public void testEnded(String arg0) {
        if(log.isDebugEnabled()) {
            log.debug("testEnded : " + arg0);
        }
        m.clear();

        //why not....
        m = null;
        System.gc();
    }
}
