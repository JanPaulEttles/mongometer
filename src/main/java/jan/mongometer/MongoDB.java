package jan.mongometer;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;

//db.jmeter.insert({"java" : "1"})
/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 17/06/12
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */
public class MongoDB {

    private Mongo m = null;
    private DB db = null;

    private final Logger log = LoggingManager.getLoggerForClass();

    public MongoDB(
            List<String> connections,
            String database,
            int connectionsPerHost,
            int threadsAllowedToBlockForConnectionMultiplier,
            String username,
            String password) {

        try {
            if(log.isDebugEnabled()) {
                for(String connection : connections) {
                    log.debug("connection: " + connection);
                }
                log.debug("database: " + database);
                log.debug("username: " + username);
                log.debug("password: " + password);
            }

            ArrayList<ServerAddress> addresses = new ArrayList<ServerAddress>();

            for(String connection : connections) {
                addresses.add(new ServerAddress(connection, 27017));
            }
            m = new Mongo(addresses);
            m.getMongoOptions().connectionsPerHost = connectionsPerHost;
            m.getMongoOptions().threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;

            db = m.getDB(database);

            boolean authenticated = db.authenticate(username, password.toCharArray());
            if(log.isDebugEnabled()) {
                log.debug("authenticated: " + authenticated);
            }
        }
        catch(UnknownHostException uhe) {
            if(log.isWarnEnabled()) {
                log.warn("", uhe);
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
    public synchronized void evaluate(String script) {

        if(log.isWarnEnabled()) {
            log.warn("script: " + script);
        }
        db.requestStart();
        db.requestEnsureConnection();
        db.eval(script);
        db.requestDone();
    }

    public void clear() {
        if(log.isWarnEnabled()) {
            log.warn("clearing");
        }

        m.close();

        //there is no harm in trying to clear up
        db = null;
        m = null;
        System.gc();
    }
}
