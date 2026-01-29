package exceptions;

/**
 * Checked exception thrown when engine specifications are invalid.
 * This exception must be explicitly caught or declared in method signatures.
 * Used for critical engine validation failures.
 */
public class InvalidEngineException extends Exception {
    /**
     * Creates an InvalidEngineException with a descriptive message.
     * Precondition: message describes the invalid engine specification
     * Postcondition: exception is created and ready to be thrown
     */
    public InvalidEngineException(String message) {
        super(message);
    }
}
