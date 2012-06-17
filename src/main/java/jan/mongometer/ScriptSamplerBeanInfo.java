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
 * To change this template use File | Settings | File Templates.
 */
public class ScriptSamplerBeanInfo extends BeanInfoSupport {
    public ScriptSamplerBeanInfo() {
        super(ScriptSampler.class);

        createPropertyGroup("mongodb", new String[] {
                "connection",
                "connectionsPerHost",
                "threadsAllowedToBlockForConnectionMultiplier",
                "database",
                "username",
                "password" });

        PropertyDescriptor p = property("connection");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
        p = property("connectionsPerHost");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        //based on 20,000 available connections on db.serverStatus()
        p.setValue(DEFAULT, "4000");
        p = property("threadsAllowedToBlockForConnectionMultiplier");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        //based on 20,000 available connections on db.serverStatus() and the docs saying this is the default multiplier
        p.setValue(DEFAULT, "5");
        p = property("database");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
        p = property("username");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
        p = property("password", TypeEditor.PasswordEditor);
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");

        createPropertyGroup("script_sampler", new String[]{"script"});

        PropertyDescriptor pd = property("script");
        pd.setValue(NOT_UNDEFINED, Boolean.FALSE);
        pd.setValue(DEFAULT, "");
        pd.setValue(NOT_EXPRESSION, Boolean.TRUE);
        pd.setPropertyEditorClass(TextAreaEditor.class);
    }
}
