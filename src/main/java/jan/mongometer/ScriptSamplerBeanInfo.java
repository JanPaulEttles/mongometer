package jan.mongometer;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TextAreaEditor;
import org.apache.jmeter.testbeans.gui.TypeEditor;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 17/06/12
 * Time: 20:49
  */
public class ScriptSamplerBeanInfo
        extends BeanInfoSupport {

    private static final Logger log = LoggingManager.getLoggerForClass();

    public ScriptSamplerBeanInfo() {
        super(ScriptSampler.class);

        //http://api.mongodb.org/java/2.7.2/com/mongodb/Mongo.html
        createPropertyGroup("mongodb", new String[] {
                "connection",
                "database",
                "username",
                "password" });

        //http://api.mongodb.org/java/2.7.2/com/mongodb/MongoOptions.html/
        createPropertyGroup("options", new String[]{
                "autoConnectRetry",
                "connectionsPerHost",
                "connectTimeout",
                "maxAutoConnectRetryTime",
                "maxWaitTime",
                "socketTimeout",
                "socketKeepAlive",
                "threadsAllowedToBlockForConnectionMultiplier"});

        //http://api.mongodb.org/java/2.7.2/com/mongodb/MongoOptions.html/
        createPropertyGroup("writeConcern", new String[] {
                "fsync",
                "safe",
                "waitForJournaling",
                "writeOperationNumberOfServers",
                "writeOperationTimeout" });

        createPropertyGroup("sampler", new String[]{
                "script"});

        PropertyDescriptor p = property("connection");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
        p = property("database");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
        p = property("username");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
        p = property("password", TypeEditor.PasswordEditor);
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");

        p = property("autoConnectRetry");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);
        p = property("connectionsPerHost");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "10");
        p = property("connectTimeout");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");
        p = property("threadsAllowedToBlockForConnectionMultiplier");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "5");
        p = property("maxAutoConnectRetryTime");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");
        p = property("maxWaitTime");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "120000");
        p = property("socketTimeout");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");
        p = property("socketKeepAlive");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);

        p = property("fsync");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);
        p = property("safe");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);
        p = property("waitForJournaling");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);
        p = property("writeOperationNumberOfServers");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");
        p = property("writeOperationTimeout");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");

        p = property("script");
        p.setValue(NOT_UNDEFINED, Boolean.FALSE);
        p.setValue(DEFAULT, "");
        p.setValue(NOT_EXPRESSION, Boolean.TRUE);
        p.setPropertyEditorClass(TextAreaEditor.class);

        if(log.isDebugEnabled()) {
            for (PropertyDescriptor pd : getPropertyDescriptors()) {
                log.debug(pd.getName());
                log.debug(pd.getDisplayName());
            }
        }
    }
}