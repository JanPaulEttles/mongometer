package jan.mongometer.sampler;

import jan.mongometer.sampler.MongoScriptSampler;
import org.apache.jmeter.samplers.SampleResult;
import org.junit.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * User: jan
 */
public class MongoScriptSamplerTest {

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
    public void testSourceProperty() {
        MongoScriptSampler instance = new MongoScriptSampler();
        instance.setSource(TEST_STRING);
        assertSame(instance.getSource(), TEST_STRING);
    }

    @Test
    public void testDatabaseProperty() {
        MongoScriptSampler instance = new MongoScriptSampler();
        instance.setDatabase(TEST_STRING);
        assertSame(instance.getDatabase(), TEST_STRING);
    }

    @Test
    public void testUsernameProperty() {
        MongoScriptSampler instance = new MongoScriptSampler();
        instance.setUsername(TEST_STRING);
        assertSame(instance.getUsername(), TEST_STRING);
    }

    @Test
    public void testPasswordProperty() {
        MongoScriptSampler instance = new MongoScriptSampler();
        instance.setPassword(TEST_STRING);
        assertSame(instance.getPassword(), TEST_STRING);
    }

    @Test
    public void testScript() {
        MongoScriptSampler instance = new MongoScriptSampler();
        instance.setScript(TEST_STRING);
        assertSame(instance.getScript(), TEST_STRING);
    }

    @Test
    public void testScriptSampler() {
        MongoScriptSamplerMock instance = new MongoScriptSamplerMock();
        SampleResult result = new SampleResult();


    }
}