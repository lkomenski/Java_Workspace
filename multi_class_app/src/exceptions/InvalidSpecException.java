package exceptions;

/**
 * Unchecked exception thrown when an invalid specification is provided.
 * This is a RuntimeException and does not need to be explicitly caught.
 */
public class InvalidSpecException extends RuntimeException {
    /**
     * Creates an InvalidSpecException with a descriptive message.
     * Precondition: message describes the invalid specification
     * Postcondition: exception is created and ready to be thrown
     */
    public InvalidSpecException(String message) {
        super(message);
    }
}
