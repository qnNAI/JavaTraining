package by.training.task01.composite.compositeException;

public class CompositeException extends Exception {
    public CompositeException() {
        super();
    }

    public CompositeException(String message) {
        super(message);
    }

    public CompositeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompositeException(Throwable cause) {
        super(cause);
    }
}
