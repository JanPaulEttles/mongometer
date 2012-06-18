package jan.mongometer;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TextAreaEditor;
import org.apache.jmeter.testbeans.gui.TypeEditor;

/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 17/06/12
 * Time: 20:49
  */
public class ScriptSamplerBeanInfo
    extends BeanInfoSupport {

    public ScriptSamplerBeanInfo() {
        super(ScriptSampler.class);

        //http://api.mongodb.org/java/2.7.2/com/mongodb/Mongo.html
        createPropertyGroup("mongodb", new String[] {
                "connection",
                "database",
                "username",
                "password" });

        PropertyDescriptor mongodb = property("connection");
        mongodb.setValue(NOT_UNDEFINED, Boolean.TRUE);
        mongodb.setValue(DEFAULT, "");

        mongodb = property("database");
        mongodb.setValue(NOT_UNDEFINED, Boolean.TRUE);
        mongodb.setValue(DEFAULT, "");

        mongodb = property("username");
        mongodb.setValue(NOT_UNDEFINED, Boolean.TRUE);
        mongodb.setValue(DEFAULT, "");

        mongodb = property("password", TypeEditor.PasswordEditor);
        mongodb.setValue(NOT_UNDEFINED, Boolean.TRUE);
        mongodb.setValue(DEFAULT, "");

        //http://api.mongodb.org/java/2.7.2/com/mongodb/MongoOptions.html/
        createPropertyGroup("options", new String[] {
                "autoConnectRetry",
                "connectionsPerHost",
                "connectTimeout",
                "fsync",
                "j",
                "maxAutoConnectRetryTime",
                "maxWaitTime",
                "safe",
                "socketTimeout",
                "socketKeepAlive",
                "threadsAllowedToBlockForConnectionMultiplier",
                "w",
                "wtimeout" });

        PropertyDescriptor p = property("autoConnectRetry");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);

        p = property("connectionsPerHost");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        //based on 20,000 available connections on db.serverStatus()
        p.setValue(DEFAULT, "4000");

        p = property("connectTimeout");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");

        p = property("fsync");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);

        p = property("j");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);

        p = property("maxAutoConnectRetryTime");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");

        p = property("maxWaitTime");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "120000");

        p = property("safe");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);

        p = property("socketKeepAlive");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, Boolean.FALSE);

        p = property("socketTimeout");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");

        p = property("threadsAllowedToBlockForConnectionMultiplier");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        //based on 20,000 available connections on db.serverStatus() and the docs saying this is the default multiplier
        p.setValue(DEFAULT, "5");

        p = property("w");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");

        p = property("wtimeout");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "0");

        createPropertyGroup("sampler", new String[] {
                "script" });

        PropertyDescriptor sampler = property("script");
        sampler.setValue(NOT_UNDEFINED, Boolean.FALSE);
        sampler.setValue(DEFAULT, "");
        sampler.setValue(NOT_EXPRESSION, Boolean.TRUE);
        sampler.setPropertyEditorClass(TextAreaEditor.class);
    }
}