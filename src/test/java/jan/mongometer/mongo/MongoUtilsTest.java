package jan.mongometer.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;
import org.junit.*;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;

/**
 * User: jan
 */
public class MongoUtilsTest {

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
    public void testLocalhost() {
        String host = "127.0.0.1";
        int port = 27017;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1");
        assertEquals(expected, actual);
    }

    @Test
    public void testLocalhostDifferentDefaultPorts() {
        String host = "127.0.0.1";
        int port = 27018;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1");
        assertNotSame(expected, actual);
    }

    @Test
    public void testLocalhost27017() {
        String host = "127.0.0.1";
        int port = 27017;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1:27017");

        assertEquals(expected, actual);
    }

    @Test
    public void testLocalhost27017DifferentPorts() {
        String host = "127.0.0.1";
        int port = 27018;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1:27017");
        assertNotSame(expected, actual);
    }

    @Test
    public void testLocalhost27017WithSpaces() {
        String host = "127.0.0.1";
        int port = 27017;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses(" 127.0.0.1 : 27017 ");
        assertEquals(expected, actual);
    }

    @Test
    public void testLocalhost27017Otherhost() {
        String host = "127.0.0.1";
        String host1 = "127.0.0.1";
        int port = 27017;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
            expected.add(new ServerAddress(host1, port));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1:27017,127.0.0.1");
        assertEquals(expected, actual);
    }
    @Test
    public void testLocalhost27017Otherhost27018() {
        String host = "127.0.0.1";
        String host1 = "127.0.0.1";
        int port = 27017;
        int port1 = 27018;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
            expected.add(new ServerAddress(host1, port1));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1:27017,127.0.0.1:27018");
        assertEquals(expected, actual);
    }

    @Test
    public void testLocalhost27017Otherhost27018WithSpaces() {
        String host = "127.0.0.1";
        String host1 = "127.0.0.1";
        int port = 27017;
        int port1 = 27018;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
            expected.add(new ServerAddress(host1, port1));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses(" 127.0.0.1 : 27017 , 127.0.0.1 : 27018 ");
        assertEquals(expected, actual);
    }

    @Test
    public void testLocalhost27017Otherhost27018Otherhost27019() {
        String host = "127.0.0.1";
        String host1 = "127.0.0.1";
        String host2 = "127.0.0.1";
        int port = 27017;
        int port1 = 27018;
        int port2 = 27019;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
            expected.add(new ServerAddress(host1, port1));
            expected.add(new ServerAddress(host2, port2));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses("127.0.0.1:27017,127.0.0.1:27018,127.0.0.1:27019");
        assertEquals(expected, actual);
    }

    @Test
    public void testLocalhost27017Otherhost27018Otherhost27019WithSpaces() {
        String host = "127.0.0.1";
        String host1 = "127.0.0.1";
        String host2 = "127.0.0.1";
        int port = 27017;
        int port1 = 27018;
        int port2 = 27019;

        ArrayList<ServerAddress> expected = new ArrayList<ServerAddress>();
        try {
            expected.add(new ServerAddress(host, port));
            expected.add(new ServerAddress(host1, port1));
            expected.add(new ServerAddress(host2, port2));
        }
        catch(UnknownHostException uhe) {
        }

        ArrayList<ServerAddress> actual = MongoUtils.toServerAddresses(" 127.0.0.1 : 27017 , 127.0.0.1 : 27018 , 127.0.0.1 : 27019 ");
        assertEquals(expected, actual);
    }
}