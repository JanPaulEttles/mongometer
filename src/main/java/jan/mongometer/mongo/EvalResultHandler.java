package jan.mongometer.mongo;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * User: jan
 */
public class EvalResultHandler {

    //This can lead to code smell, meh! Do we care
    public String handle(Object o) {
        if(o == null){
            return "ok";
        }

        if(o instanceof Double) {
            return this.handle((Double)o);
        }
        else if(o instanceof Integer) {
            return this.handle((Integer)o);
        }
        else if(o instanceof String) {
            return this.handle((String)o);
        }
        else if(o instanceof DBObject) {
            return this.handle((DBObject)o);
        }
        else {
            return "return type not handled";
        }
    }

    public String handle(Integer o)
        throws MongoMeterException {

        if(!(o instanceof Integer)) {
            throw new MongoMeterException("turns out parameter wasn't an instanceof Integer after all");
        }
        return o.toString();
    }

    public String handle(String o)
        throws MongoMeterException {

        if(!(o instanceof String)) {
            throw new MongoMeterException("turns out parameter wasn't an instanceof String after all");
        }
        return o;
    }

    public String handle(Double o)
        throws MongoMeterException {

        if(!(o instanceof Double)) {

            throw new MongoMeterException("turns out parameter wasn't an instanceof Double after all");
        }
        return o.toString();
    }


    public String handle(DBObject o)
        throws MongoMeterException {

        if(!(o instanceof DBObject)) {
            throw new MongoMeterException("turns out parameter wasn't an instanceof DBObject after all");
        }
        return JSON.serialize((DBObject) o);
    }
}
