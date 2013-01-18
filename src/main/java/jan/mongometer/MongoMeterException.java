package jan.mongometer;

public class MongoMeterException
    extends RuntimeException {

    public MongoMeterException(String message) {
        super(message);
    }

    public MongoMeterException(String message, Throwable throwable) {
        super(message, throwable);
    }
}