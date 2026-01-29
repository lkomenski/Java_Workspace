package exceptions;

/**
 * Unchecked exception thrown when wheel specifications are invalid.
 * This is a RuntimeException and does not need to be explicitly caught.
 * Used for wheel size or pressure validation failures.
 */
public class InvalidWheelSpecException extends RuntimeException {
    /**
     * Creates an InvalidWheelSpecException with a descriptive message.
     * Precondition: message describes the invalid wheel specification
     * Postcondition: exception is created and ready to be thrown
     */
    public InvalidWheelSpecException(String message) {
        super(message);
    }
}
