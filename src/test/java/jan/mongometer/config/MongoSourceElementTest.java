package jan.mongometer.config;

import jan.mongometer.config.MongoSourceElement;
import org.apache.jmeter.samplers.SampleResult;
import org.junit.*;

import static org.junit.Assert.assertSame;

/**
 * User: jan
 */
public class MongoSourceElementTest {
    private static String TEST_STRING = "some blah blah blah de blah";

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
        MongoSourceElement instance = new MongoSourceElement();
        instance.setConnection(TEST_STRING);
        assertSame(instance.getConnection(), TEST_STRING);
    }

    @Test
    public void testSourceProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setConnection(TEST_STRING);
        assertSame(instance.getConnection(), TEST_STRING);
    }

    @Test
    public void testAutoConnectRetryProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setAutoConnectRetry(TEST_STRING);
        assertSame(instance.getAutoConnectRetry(), TEST_STRING);
    }

    @Test
    public void testConnectionsPerHostProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setConnectionsPerHost(TEST_STRING);
        assertSame(instance.getConnectionsPerHost(), TEST_STRING);
    }

    @Test
    public void testConnectTimeoutProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setConnectTimeout(TEST_STRING);
        assertSame(instance.getConnectTimeout(), TEST_STRING);
    }

    @Test
    public void testMaxAutoConnectRetryTimeProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setMaxAutoConnectRetryTime(TEST_STRING);
        assertSame(instance.getMaxAutoConnectRetryTime(), TEST_STRING);
    }

    @Test
    public void testMaxWaitTimeProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setMaxWaitTime(TEST_STRING);
        assertSame(instance.getMaxWaitTime(), TEST_STRING);
    }

    @Test
    public void testSocketKeepAliveProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setSocketKeepAlive(TEST_STRING);
        assertSame(instance.getSocketKeepAlive(), TEST_STRING);
    }

    @Test
    public void testSocketTimeoutProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setSocketTimeout(TEST_STRING);
        assertSame(instance.getSocketTimeout(), TEST_STRING);
    }

    @Test
    public void testThreadsAllowedToBlockForConnectionMultiplierProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setThreadsAllowedToBlockForConnectionMultiplier(TEST_STRING);
        assertSame(instance.getThreadsAllowedToBlockForConnectionMultiplier(), TEST_STRING);
    }

    @Test
    public void testFsyncProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setFsync(TEST_STRING);
        assertSame(instance.getFsync(), TEST_STRING);
    }

    @Test
    public void testSafeProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setSafe(TEST_STRING);
        assertSame(instance.getSafe(), TEST_STRING);
    }

    @Test
    public void testWaitForJournalingProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setWaitForJournaling(TEST_STRING);
        assertSame(instance.getWaitForJournaling(), TEST_STRING);
    }

    @Test
    public void testWriteOperationNumberOfServersProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setWriteOperationNumberOfServers(TEST_STRING);
        assertSame(instance.getWriteOperationNumberOfServers(), TEST_STRING);
    }

    @Test
    public void testWriteOperationTimeoutProperty() {
        MongoSourceElement instance = new MongoSourceElement();
        instance.setWriteOperationTimeout(TEST_STRING);
        assertSame(instance.getWriteOperationTimeout(), TEST_STRING);
    }
}
