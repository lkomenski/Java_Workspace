package exceptions;

/**
 * Checked exception thrown when the wheel count is invalid.
 * This exception must be explicitly caught or declared in method signatures.
 */
public class InvalidWheelCountException extends Exception {
    /**
     * Creates an InvalidWheelCountException with a descriptive message.
     * Precondition: message describes the invalid wheel count
     * Postcondition: exception is created and ready to be thrown
     */
    public InvalidWheelCountException(String message) {
        super(message);
    }
}
