package jan.mongometer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: jan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        jan.mongometer.config.MongoSourceElementTest.class,
        jan.mongometer.mongo.EvalResultHandlerTest.class,
        jan.mongometer.sampler.MongoScriptSamplerTest.class,
        jan.mongometer.mongo.MongoUtilsTest.class
})
public class AllTests {
}
