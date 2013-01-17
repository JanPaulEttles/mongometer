package jan.mongometer.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import jan.mongometer.mongo.EvalResultHandler;
import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * User: jan
 */
public class EvalResultHandlerTest {

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
    public void testDouble() {
        Double testDouble = new Double(2.0);

        String expected = testDouble.toString();
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(new Double(2.0));

        assertEquals(expected, actual);
    }

    @Test
    public void testDBObject() {
        DBObject testDBObject = new BasicDBObject();
        testDBObject.put("name", "jan");
        testDBObject.put("super power", "invisibility");

        String expected = JSON.serialize(testDBObject);
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(testDBObject);

        assertEquals(expected, actual);
    }

    @Test
    public void testInteger() {
        Integer testInteger = new Integer(2);

        String expected = testInteger.toString();
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(new Integer(2));

        assertEquals(expected, actual);
    }

    @Test
    public void testString() {
        String testString = new String("jan");

        String expected = testString;
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(new String("jan"));

        assertEquals(expected, actual);
    }
}