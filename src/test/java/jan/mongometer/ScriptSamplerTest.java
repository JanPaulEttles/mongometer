package jan.mongometer;

import static org.junit.Assert.assertSame;

import jan.mongometer.ScriptSampler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 17/06/12
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class ScriptSamplerTest {

    private static String TEST_STRING = "blah blah blah";

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
    public void testScript() {
        ScriptSampler instance = new ScriptSampler();
        instance.setScript(TEST_STRING);
        assertSame(instance.getScript(), TEST_STRING);
    }

    @Test
    public void testThreadsAllowedToBlockForConnectionMultiplierProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setThreadsAllowedToBlockForConnectionMultiplier(TEST_STRING);
        assertSame(instance.getThreadsAllowedToBlockForConnectionMultiplier(), TEST_STRING);
    }

    @Test
    public void testConnectionsPerHostProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setConnectionsPerHost(TEST_STRING);
        assertSame(instance.getConnectionsPerHost(), TEST_STRING);
    }

    @Test
    public void testConnectionProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setConnection(TEST_STRING);
        assertSame(instance.getConnection(), TEST_STRING);
    }

    @Test
    public void testDatabaseProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setDatabase(TEST_STRING);
        assertSame(instance.getDatabase(), TEST_STRING);
    }

    @Test
    public void testUsernameProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setUsername(TEST_STRING);
        assertSame(instance.getUsername(), TEST_STRING);
    }

    @Test
    public void testPasswordProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setPassword(TEST_STRING);
        assertSame(instance.getPassword(), TEST_STRING);
    }
}
