package jan.mongometer;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 17/06/12
 * Time: 20:46
 */
//db.jmeter.insert({"java" : "1"})
public class MongoDB {

    private final Logger log = LoggingManager.getLoggerForClass();

    private Mongo mongo = null;
    private DB db = null;

    public MongoDB(
            ArrayList<ServerAddress> serverAddresses,
            String database,
            String username,
            String password,
            MongoOptions mongoOptions) {

        try {
            if(log.isDebugEnabled()) {
                log.debug("database: " + database);
                log.debug("username: " + username);
                log.debug("password: " + password);
            }

            mongo = new Mongo(serverAddresses, mongoOptions);
            db = mongo.getDB(database);

            boolean authenticated = db.authenticate(username, password.toCharArray());
            if(log.isDebugEnabled()) {
                log.debug("authenticated: " + authenticated);
            }
        }
        catch(Exception e) {
            if(log.isWarnEnabled()) {
                log.warn("catch all", e);
            }
        }
        finally {
        }
    }

    public synchronized String evaluate(String script)
        throws Exception {

        if(log.isDebugEnabled()) {
            log.debug("script: " + script);
        }

        db.requestStart();
        db.requestEnsureConnection();

        String result = null;
        Object o = db.eval(script);
        if(o instanceof DBObject) {
            result = JSON.serialize((DBObject)o);
        }
        else if(o instanceof Double) {
            result = o.toString();
        }
        else if(o == null) {
            //calls such as insert do not return anything
            result = "ok";
        }
        else {
            //we may want to implement a handler for unexpected return types
            throw new Exception("Unexpected return type " + o);
        }
        db.requestDone();
        return result;
    }

    public void clear() {
        if(log.isDebugEnabled()) {
            log.debug("clearing");
        }

        mongo.close();

        //there is no harm in trying to clear up
        db = null;
        mongo = null;
        System.gc();
    }
}