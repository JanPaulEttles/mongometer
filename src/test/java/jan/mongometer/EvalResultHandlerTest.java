package jan.mongometer;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import jan.mongometer.ScriptSampler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jan
 * Date: 25/06/12
 * Time: 19:29
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
        Double TEST_DOUBLE = new Double(2.0);

        String expected = TEST_DOUBLE.toString();
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(new Double(2.0));

        assertEquals(expected, actual);

    }

    @Test
    public void testDBObject() {
        DBObject TEST_DBOBJECT = new BasicDBObject();
        TEST_DBOBJECT.put("name", "jan");
        TEST_DBOBJECT.put("super power", "invisibility");

        String expected = JSON.serialize(TEST_DBOBJECT);
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(TEST_DBOBJECT);

        assertEquals(expected, actual);
    }

    @Test
    public void testInteger() {
        Integer TEST_INTEGER = new Integer(2);

        String expected = TEST_INTEGER.toString();
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(new Integer(2));

        assertEquals(expected, actual);
    }

    @Test
    public void testString() {
        String TEST_STRING = new String("jan");

        String expected = TEST_STRING;
        EvalResultHandler evalResultHandler = new EvalResultHandler();
        String actual = evalResultHandler.handle(new String("jan"));

        assertEquals(expected, actual);
    }
}
