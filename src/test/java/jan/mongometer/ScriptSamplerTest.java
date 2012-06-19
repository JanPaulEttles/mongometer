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



    @Test
    public void testAutoConnectRetryProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setAutoConnectRetry(TEST_STRING);
        assertSame(instance.getAutoConnectRetry(), TEST_STRING);
    }

    @Test
    public void testConnectionsPerHostProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setConnectionsPerHost(TEST_STRING);
        assertSame(instance.getConnectionsPerHost(), TEST_STRING);
    }

    @Test
    public void testConnectTimeoutProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setConnectTimeout(TEST_STRING);
        assertSame(instance.getConnectTimeout(), TEST_STRING);
    }

    @Test
    public void testMaxAutoConnectRetryTimeProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setMaxAutoConnectRetryTime(TEST_STRING);
        assertSame(instance.getMaxAutoConnectRetryTime(), TEST_STRING);
    }

    @Test
    public void testMaxWaitTimeProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setMaxWaitTime(TEST_STRING);
        assertSame(instance.getMaxWaitTime(), TEST_STRING);
    }

    @Test
    public void testSocketKeepAliveProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setSocketKeepAlive(TEST_STRING);
        assertSame(instance.getSocketKeepAlive(), TEST_STRING);
    }

    @Test
    public void testSocketTimeoutProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setSocketTimeout(TEST_STRING);
        assertSame(instance.getSocketTimeout(), TEST_STRING);
    }

    @Test
    public void testThreadsAllowedToBlockForConnectionMultiplierProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setThreadsAllowedToBlockForConnectionMultiplier(TEST_STRING);
        assertSame(instance.getThreadsAllowedToBlockForConnectionMultiplier(), TEST_STRING);
    }



    @Test
    public void testFsyncProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setFsync(TEST_STRING);
        assertSame(instance.getFsync(), TEST_STRING);
    }

    @Test
    public void testSafeProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setSafe(TEST_STRING);
        assertSame(instance.getSafe(), TEST_STRING);
    }

    @Test
    public void testWaitForJournalingProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setWaitForJournaling(TEST_STRING);
        assertSame(instance.getWaitForJournaling(), TEST_STRING);
    }

    @Test
    public void testWriteOperationNumberOfServersProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setWriteOperationNumberOfServers(TEST_STRING);
        assertSame(instance.getWriteOperationNumberOfServers(), TEST_STRING);
    }

    @Test
    public void testWriteOperationTimeoutProperty() {
        ScriptSampler instance = new ScriptSampler();
        instance.setWriteOperationTimeout(TEST_STRING);
        assertSame(instance.getWriteOperationTimeout(), TEST_STRING);
    }



    @Test
    public void testScript() {
        ScriptSampler instance = new ScriptSampler();
        instance.setScript(TEST_STRING);
        assertSame(instance.getScript(), TEST_STRING);
    }
}