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
        db = null;
        mongo = null;
        System.gc();
    }
}