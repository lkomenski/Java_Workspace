package carparts;

import exceptions.InvalidSpecException;
import exceptions.InvalidEngineException;

/**
 * Represents a car engine with horsepower and type.
 */
public class Engine {
    private int horsepower;
    private String type;

    /**
     * Creates an Engine with specified horsepower and type.
     * Precondition: horsepower > 0, type is not blank
     * Postcondition: Engine object is created with valid values
     */
    public Engine(int horsepower, String type) throws InvalidEngineException {
        try {
            setHorsepower(horsepower);
            setType(type);
        } catch (InvalidSpecException e) {
            throw new InvalidEngineException("Engine creation failed: " + e.getMessage());
        }
    }

    /**
     * Sets the horsepower of the engine.
     * Precondition: horsepower > 0
     * Postcondition: horsepower is assigned and valid
     */
    public void setHorsepower(int horsepower) {
        if (horsepower <= 0) {
            throw new InvalidSpecException("Horsepower must be positive.");
        }
        this.horsepower = horsepower;
    }

    /**
     * Sets the type of the engine.
     * Precondition: type must not be blank and must contain at least one letter
     * Postcondition: type is assigned
     */
    public void setType(String type) {
        if (type == null || type.isBlank()) {
            throw new InvalidSpecException("Engine type cannot be blank.");
        }
        if (!type.matches(".*[a-zA-Z].*")) {
            throw new InvalidSpecException("Engine type must contain at least one letter.");
        }
        this.type = type;
    }

    /**
     * Gets the horsepower of the engine.
     * Precondition: none
     * Postcondition: returns the horsepower value
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Gets the type of the engine.
     * Precondition: none
     * Postcondition: returns the engine type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return horsepower + " HP " + type;
    }
}
