package jan.mongometer.config;

import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import jan.mongometer.mongo.MongoDB;
import jan.mongometer.MongoMeterException;
import org.apache.jmeter.config.ConfigElement;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: jan
 */
public class MongoSourceElement
    extends AbstractTestElement
        implements ConfigElement, TestStateListener, TestBean {

    private static final Logger log = LoggingManager.getLoggerForClass();

    public final static String CONNECTION = "MongoSourceElement.connection"; //$NON-NLS-1$
    public final static String SOURCE = "MongoSourceElement.source"; //$NON-NLS-1$

    public final static String AUTO_CONNECT_RETRY = "MongoSourceElement.autoConnectRetry"; //$NON-NLS-1$
    public final static String CONNECTIONS_PER_HOST = "MongoSourceElement.connectionsPerHost"; //$NON-NLS-1$
    public final static String CONNECT_TIMEOUT = "MongoSourceElement.connectTimeout"; //$NON-NLS-1$
    public final static String MAX_AUTO_CONNECT_RETRY_TIME = "MongoSourceElement.maxAutoConnectRetryTime"; //$NON-NLS-1$
    public final static String MAX_WAIT_TIME = "MongoSourceElement.maxWaitTime"; //$NON-NLS-1$
    public final static String SOCKET_TIMEOUT = "MongoSourceElement.socketTimeout"; //$NON-NLS-1$
    public final static String SOCKET_KEEP_ALIVE = "MongoSourceElement.socketKeepAlive"; //$NON-NLS-1$
    public final static String THREADS_ALLOWED_TO_BLOCK_MULTIPLIER = "MongoSourceElement.threadsAllowedToBlockForConnectionMultiplier"; //$NON-NLS-1$

    public final static String FSYNC = "MongoSourceElement.fsync"; //$NON-NLS-1$
    public final static String SAFE = "MongoSourceElement.safe"; //$NON-NLS-1$
    public final static String WAIT_FOR_JOURNALING = "MongoSourceElement.waitForJournaling"; //$NON-NLS-1$
    public final static String WRITE_OPERATION_NUMBER_OF_SERVERS = "MongoSourceElement.writeOperationNumberOfServers"; //$NON-NLS-1$
    public final static String WRITE_OPERATION_TIMEOUT = "MongoSourceElement.writeOperationTimeout"; //$NON-NLS-1$

    public String getTitle() {
        return this.getName();
    }

    public String getConnection() {
        return getPropertyAsString(CONNECTION);
    }

    public void setConnection(String connection) {
        setProperty(CONNECTION, connection);
    }

    public String getSource() {
        return getPropertyAsString(SOURCE);
    }

    public void setSource(String source) {
        setProperty(SOURCE, source);
    }

    public String getAutoConnectRetry() {
        return getPropertyAsString(AUTO_CONNECT_RETRY);
    }

    public void setAutoConnectRetry(String autoConnectRetry) {
        setProperty(AUTO_CONNECT_RETRY, autoConnectRetry);
    }

    public String getConnectionsPerHost() {
        return getPropertyAsString(CONNECTIONS_PER_HOST);
    }

    public void setConnectionsPerHost(String connectionsPerHost) {
        setProperty(CONNECTIONS_PER_HOST, connectionsPerHost);
    }

    public String getConnectTimeout() {
        return getPropertyAsString(CONNECT_TIMEOUT);
    }

    public void setConnectTimeout(String connectTimeout) {
        setProperty(CONNECT_TIMEOUT, connectTimeout);
    }

    public String getMaxAutoConnectRetryTime() {
        return getPropertyAsString(MAX_AUTO_CONNECT_RETRY_TIME);
    }

    public void setMaxAutoConnectRetryTime(String maxAutoConnectRetryTime) {
        setProperty(MAX_AUTO_CONNECT_RETRY_TIME, maxAutoConnectRetryTime);
    }

    public String getMaxWaitTime() {
        return getPropertyAsString(MAX_WAIT_TIME);
    }

    public void setMaxWaitTime(String maxWaitTime) {
        setProperty(MAX_WAIT_TIME, maxWaitTime);
    }

    public String getSocketTimeout() {
        return getPropertyAsString(SOCKET_TIMEOUT);
    }

    public void setSocketTimeout(String socketTimeout) {
        setProperty(SOCKET_TIMEOUT, socketTimeout);
    }

    public String getSocketKeepAlive() {
        return getPropertyAsString(SOCKET_KEEP_ALIVE);
    }

    public void setSocketKeepAlive(String socketKeepAlive) {
        setProperty(SOCKET_KEEP_ALIVE, socketKeepAlive);
    }

    public String getThreadsAllowedToBlockForConnectionMultiplier() {
        return getPropertyAsString(THREADS_ALLOWED_TO_BLOCK_MULTIPLIER);
    }

    public void setThreadsAllowedToBlockForConnectionMultiplier(String threadsAllowed) {
        setProperty(THREADS_ALLOWED_TO_BLOCK_MULTIPLIER, threadsAllowed);
    }

    public String getFsync() {
        return getPropertyAsString(FSYNC);
    }

    public void setFsync(String fsync) {
        setProperty(FSYNC, fsync);
    }

    public String getSafe() {
        return getPropertyAsString(SAFE);
    }

    public void setSafe(String safe) {
        setProperty(SAFE, safe);
    }

    public String getWaitForJournaling() {
        return getPropertyAsString(WAIT_FOR_JOURNALING);
    }

    public void setWaitForJournaling(String waitForJournaling) {
        setProperty(WAIT_FOR_JOURNALING, waitForJournaling);
    }

    public String getWriteOperationNumberOfServers() {
        return getPropertyAsString(WRITE_OPERATION_NUMBER_OF_SERVERS);
    }

    public void setWriteOperationNumberOfServers(String writeOperationNumberOfServers) {
        setProperty(WRITE_OPERATION_NUMBER_OF_SERVERS, writeOperationNumberOfServers);
    }

    public String getWriteOperationTimeout() {
        return getPropertyAsString(WRITE_OPERATION_TIMEOUT);
    }

    public void setWriteOperationTimeout(String writeOperationTimeout) {
        setProperty(WRITE_OPERATION_TIMEOUT, writeOperationTimeout);
    }

    public static MongoDB getMongoDB(String source)
            throws MongoMeterException {

        Object mongoSource = JMeterContextService.getContext().getVariables().getObject(source);

        if(mongoSource == null) {
            throw new MongoMeterException("mongoSource is null");
        }
        else {
            if(mongoSource instanceof MongoDB) {
                return (MongoDB)mongoSource;
            }
            else {
                throw new MongoMeterException("ooops, something went awry with the cast.");
            }
        }
    }

    @Override
    public void addConfigElement(ConfigElement configElement) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean expectsModification() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void testStarted() {
        if(log.isDebugEnabled()) {
            log.debug(getTitle() + " testStarted");
        }
        ArrayList<ServerAddress> addresses = new ArrayList<ServerAddress>();
        try {
            for(String connection : Arrays.asList(getConnection().split("\\s*,\\s*"))) {
                addresses.add(new ServerAddress(connection, 27017));
                if(log.isDebugEnabled()) {
                    log.debug("address : " + connection);
                }
            }
        }
        catch(UnknownHostException uhe) {
            if(log.isWarnEnabled()) {
                log.warn("", uhe);
            }
        }

        MongoOptions mongoOptions = new MongoOptions();
        mongoOptions.autoConnectRetry = Boolean.parseBoolean(getAutoConnectRetry());
        mongoOptions.connectTimeout = Integer.parseInt(getConnectTimeout());
        mongoOptions.connectionsPerHost = Integer.parseInt(getConnectionsPerHost());
        mongoOptions.fsync = Boolean.parseBoolean(getFsync());
        mongoOptions.j = Boolean.parseBoolean(getWaitForJournaling());
        mongoOptions.maxAutoConnectRetryTime = Integer.parseInt(getMaxAutoConnectRetryTime());
        mongoOptions.maxWaitTime = Integer.parseInt(getMaxWaitTime());
        mongoOptions.safe = Boolean.parseBoolean(getSafe());
        mongoOptions.socketKeepAlive = Boolean.parseBoolean(getSocketKeepAlive());
        mongoOptions.socketTimeout = Integer.parseInt(getSocketTimeout());
        mongoOptions.threadsAllowedToBlockForConnectionMultiplier = Integer.parseInt(getThreadsAllowedToBlockForConnectionMultiplier());
        mongoOptions.w = Integer.parseInt(getWriteOperationNumberOfServers());
        mongoOptions.wtimeout = Integer.parseInt(getWriteOperationTimeout());

        if(log.isDebugEnabled()) {
            log.debug("options : " + mongoOptions.toString());
        }

        if(getThreadContext().getVariables().getObject(getSource()) != null) {
            if(log.isWarnEnabled()) {
                log.warn(getSource() + " has already been defined.");
            }
        }
        else {
            if(log.isDebugEnabled()) {
                log.debug(getSource() + "  is being defined.");
            }
            getThreadContext().getVariables().putObject(getSource(), new MongoDB(addresses, mongoOptions));
        }
    }

    @Override
    public void testStarted(String s) {
        testStarted();
    }

    @Override
    public void testEnded() {
        if(log.isDebugEnabled()) {
            log.debug(getTitle() + " testEnded");
        }
        ((MongoDB)getThreadContext().getVariables().getObject(getSource())).clear();
    }

    @Override
    public void testEnded(String s) {
        testEnded();
    }
}