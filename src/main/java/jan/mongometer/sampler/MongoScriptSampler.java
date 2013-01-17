package jan.mongometer.sampler;

import com.mongodb.DB;
import jan.mongometer.config.MongoSourceElement;
import jan.mongometer.mongo.MongoDB;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * User: jan
 */
public class MongoScriptSampler
    extends AbstractSampler
        implements TestBean {

    private static final Logger log = LoggingManager.getLoggerForClass();

    public final static String SOURCE = "MongoScriptSampler.source"; //$NON-NLS-1$

    public final static String DATABASE = "MongoScriptSampler.database"; //$NON-NLS-1$
    public final static String USERNAME = "MongoScriptSampler.username"; //$NON-NLS-1$
    public final static String PASSWORD = "MongoScriptSampler.password"; //$NON-NLS-1$

    public final static String SCRIPT = "MongoScriptSampler.script"; //$NON-NLS-1$

    private static final long serialVersionUID = -7789012234636439896L;

    public MongoScriptSampler() {
        trace("MongoScriptSampler()");
    }

    public SampleResult sample(Entry e) {
        trace("sample()");

        SampleResult res = new SampleResult();
        String data = getScript();
        String response = Thread.currentThread().getName();

        res.setSampleLabel(getTitle());
        res.setResponseCodeOK();
        res.setResponseCode("200");
        res.setSuccessful(true);
        res.setResponseMessageOK();
        res.setSamplerData(data);
        res.setDataType(SampleResult.TEXT);
        res.setContentType("text/plain"); // $NON-NLS-1$
        res.sampleStart();

        try {
            MongoDB mongoDB = MongoSourceElement.getMongoDB(getSource());
            DB db = mongoDB.getDB(getDatabase(), getUsername(), getPassword());

            MongoScriptRunner runner = new MongoScriptRunner();

            res.latencyEnd();
            res.setResponseData(runner.evaluate(db, data).getBytes());
        }
        catch (Exception ex) {
            log.warn("", ex);
            res.setResponseCode("500");// $NON-NLS-1$
            res.setSuccessful(false);
            res.setResponseMessage(ex.toString());
            res.setResponseData(ex.getMessage().getBytes());
        }
        finally {
            res.sampleEnd();
        }

        return res;
    }

    public String getTitle() {
        return this.getName();
    }

    public String getScript() {
        return getPropertyAsString(SCRIPT);
    }

    public void setScript(String script) {
        setProperty(SCRIPT, script);
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

    public String getSource() {
        return getPropertyAsString(SOURCE);
    }

    public void setSource(String source) {
        setProperty(SOURCE, source);
    }

    /*
    * Helper
    */
    private void trace(String s) {
        if(log.isDebugEnabled()) {
            log.debug(Thread.currentThread().getName() + " (" + getTitle() + " " + s + " " + this.toString());
        }
    }
}