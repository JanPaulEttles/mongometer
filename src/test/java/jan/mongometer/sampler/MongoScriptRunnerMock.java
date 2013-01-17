package jan.mongometer.sampler;

import com.mongodb.DB;

/**
 * User: jan
 */
public class MongoScriptRunnerMock
    extends MongoScriptRunner {

    public MongoScriptRunnerMock() {

    }

    @Override
    public synchronized String evaluate(DB db, String script)
            throws Exception {

        return "result";
    }
}