package jan.mongometer.mongo;

import com.mongodb.DBObject;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;
import jan.mongometer.MongoMeterException;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: jan
 */
public class MongoUtils {

    private static final Logger log = LoggingManager.getLoggerForClass();

    public static ArrayList<ServerAddress> toServerAddresses(String connections) {

        ArrayList<ServerAddress> addresses = new ArrayList<ServerAddress>();
        try {
            for(String connection : Arrays.asList(connections.split("\\s*,\\s*"))) {

                String[] hostPort = connection.split("\\s*:\\s*");


                int port = 27017;
                if(hostPort[1] != null) {
                    port = Integer.parseInt(hostPort[1]);
                }
                addresses.add(new ServerAddress(hostPort[0], port));
            }
        }
        catch(UnknownHostException uhe) {
            if(log.isWarnEnabled()) {
                log.warn("", uhe);
            }
        }

        return addresses;
    }
}
