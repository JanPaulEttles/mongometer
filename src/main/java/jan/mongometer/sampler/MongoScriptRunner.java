package jan.mongometer.sampler;

import com.mongodb.DB;
import jan.mongometer.mongo.EvalResultHandler;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * User: jan
 */
public class MongoScriptRunner {

    private final Logger log = LoggingManager.getLoggerForClass();

    public MongoScriptRunner() {
    }

    public synchronized String evaluate(DB db, String script)
        throws Exception {

        if(log.isDebugEnabled()) {
            log.debug("database: " + db.getName());
            log.debug("script: " + script);
        }

        db.requestStart();
        db.requestEnsureConnection();

        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String result = evalResultHandler.handle(db.eval(script));

        if(log.isDebugEnabled()) {
            log.debug("Result : " + result);
        }

        db.requestDone();

        if(log.isDebugEnabled()) {
            log.debug("done");
        }
        return result;
    }
}