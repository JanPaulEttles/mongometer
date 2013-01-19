package jan.mongometer.sampler;

import org.apache.jmeter.samplers.SampleResult;
import org.junit.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * User: jan
 */
public class MongoScriptRunnerTest {

    private static String TEST_STRING = "function() {return db.jmeter.find().toArray();}";

    @BeforeClass
    public static void setUpClass()
            throws Exception {
    }

    @AfterClass
    public static void tearDownClass()
            throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testScriptRunner() {
        MongoScriptRunnerMock instance = new MongoScriptRunnerMock();
        String expected = null;
        try {
            expected = instance.evaluate(null, "result");
        }
        catch (Exception e) {

        }
        assertEquals(expected, "result");
    }
}