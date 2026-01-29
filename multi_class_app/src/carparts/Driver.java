package carparts;

import exceptions.InvalidSpecException;
import exceptions.InvalidDriverException;

/**
 * Represents a driver with name and age.
 */
public class Driver {
    private String name;
    private int age;

    /**
     * Creates a Driver with specified name and age.
     * Precondition: name is not blank, age >= 16
     * Postcondition: Driver object is created with valid values
     */
    public Driver(String name, int age) throws InvalidDriverException {
        try {
            setName(name);
            setAge(age);
        } catch (InvalidSpecException e) {
            throw new InvalidDriverException("Driver creation failed: " + e.getMessage());
        }
    }

    /**
     * Sets the driver's name with proper capitalization.
     * Precondition: name is not blank
     * Postcondition: name is assigned with each word capitalized
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidSpecException("Driver name cannot be blank.");
        }
        this.name = capitalizeWords(name);
    }
    
    /**
     * Capitalizes the first letter of each word and lowercases the rest.
     * Precondition: input string is not null
     * Postcondition: returns properly formatted name
     */
    private String capitalizeWords(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                result.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    result.append(words[i].substring(1).toLowerCase());
                }
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }
        
        return result.toString();
    }

    /**
     * Sets the driver's age.
     * Precondition: age >= 16
     * Postcondition: age is assigned and valid
     */
    public void setAge(int age) {
        if (age < 16) {
            throw new InvalidSpecException("Driver must be at least 16 years old.");
        }
        this.age = age;
    }

    /**
     * Gets the driver's name.
     * Precondition: none
     * Postcondition: returns the driver's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the driver's age.
     * Precondition: none
     * Postcondition: returns the driver's age
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (age " + age + ")";
    }
}
