package exceptions;

/**
 * Checked exception thrown when driver information is invalid.
 * This exception must be explicitly caught or declared in method signatures.
 * Used for critical driver validation failures.
 */
public class InvalidDriverException extends Exception {
    /**
     * Creates an InvalidDriverException with a descriptive message.
     * Precondition: message describes the invalid driver information
     * Postcondition: exception is created and ready to be thrown
     */
    public InvalidDriverException(String message) {
        super(message);
    }
}
