package jan.mongometer.mongo;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

import jan.mongometer.MongoMeterException;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.util.ArrayList;

/**
 * User: jan
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

    public synchronized DB getDB(String database, String username, String password)
            throws MongoMeterException {

        if(log.isDebugEnabled()) {
            log.debug("username: " + username);
            log.debug("password: " + password);
            log.debug("database: " + database);
        }
        DB db = mongo.getDB(database);
        boolean authenticated = db.authenticate(username, password.toCharArray());
        if(log.isDebugEnabled()) {
            log.debug("authenticated: " + authenticated);
        }
        return db;
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