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
public class MongoDB {

    private final Logger log = LoggingManager.getLoggerForClass();

    private Mongo mongo = null;

    public MongoDB(
            ArrayList<ServerAddress> serverAddresses,
            MongoOptions mongoOptions) {

        try {
            if(log.isDebugEnabled()) {
            }

            mongo = new Mongo(serverAddresses, mongoOptions);
        }
        catch(Exception e) {
            if(log.isWarnEnabled()) {
                log.warn("catch all", e);
            }
        }
        finally {
        }
    }

    public synchronized String evaluate(String database, String username, String password, String script)
        throws Exception {

        if(log.isDebugEnabled()) {
            log.debug("username: " + username);
            log.debug("password: " + password);
            log.debug("database: " + database);
            log.debug("script: " + script);
        }
        DB db = mongo.getDB(database);
        boolean authenticated = db.authenticate(username, password.toCharArray());
        if(log.isDebugEnabled()) {
            log.debug("authenticated: " + authenticated);
        }

        db.requestStart();
        db.requestEnsureConnection();

        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String result = evalResultHandler.handle(db.eval(script));

        db.requestDone();
        return result;
    }

    public void clear() {
        if(log.isDebugEnabled()) {
            log.debug("clearing");
        }

        mongo.close();

        //there is no harm in trying to clear up
        //db = null;
        mongo = null;
        System.gc();
    }
}