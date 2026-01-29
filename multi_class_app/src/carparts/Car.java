package carparts;

import exceptions.InvalidSpecException;
import exceptions.InvalidWheelCountException;

/**
 * Represents a car composed of an engine, wheels, and a driver.
 * This demonstrates composition pattern.
 */
public class Car {
    private Engine engine;
    private Wheel[] wheels;
    private Driver driver;

    /**
     * Creates a Car with an engine, wheels array, and driver.
     * Precondition: engine != null, wheels array has 4 elements, driver != null
     * Postcondition: Car object is created with all components
     */
    public Car(Engine engine, Wheel[] wheels, Driver driver)
            throws InvalidWheelCountException {
        setEngine(engine);
        setWheels(wheels);
        setDriver(driver);
    }

    /**
     * Sets the engine of the car.
     * Precondition: engine must not be null
     * Postcondition: engine is assigned to the car
     */
    public void setEngine(Engine engine) {
        if (engine == null) {
            throw new InvalidSpecException("Engine cannot be null.");
        }
        this.engine = engine;
    }

    /**
     * Sets the wheels of the car.
     * Precondition: wheels array must not be null or empty, must have exactly 4 wheels
     * Postcondition: wheels array is assigned containing 4 valid wheels
     */
    public void setWheels(Wheel[] wheels) throws InvalidWheelCountException {
        if (wheels == null || wheels.length == 0) {
            throw new InvalidWheelCountException("Wheels array cannot be empty.");
        }
        if (wheels.length != 4) {
            throw new InvalidWheelCountException("Car must have exactly 4 wheels, but got " + wheels.length + ".");
        }
        this.wheels = wheels;
    }

    /**
     * Sets the driver of the car.
     * Precondition: driver must not be null
     * Postcondition: driver is assigned to the car
     */
    public void setDriver(Driver driver) {
        if (driver == null) {
            throw new InvalidSpecException("Driver cannot be null.");
        }
        this.driver = driver;
    }

    /**
     * Gets the engine of the car.
     * Precondition: none
     * Postcondition: returns the car's engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Gets the wheels of the car.
     * Precondition: none
     * Postcondition: returns the car's wheels array
     */
    public Wheel[] getWheels() {
        return wheels;
    }

    /**
     * Gets the driver of the car.
     * Precondition: none
     * Postcondition: returns the car's driver
     */
    public Driver getDriver() {
        return driver;
    }

    /* Format the output in a readable way  */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("ENGINE\n");
        sb.append("   ").append(engine).append("\n\n");
        
        sb.append("DRIVER\n");
        sb.append("   ").append(driver).append("\n\n");
        
        sb.append("WHEELS (").append(wheels.length).append(")\n");
        for (int i = 0; i < wheels.length; i++) {
            sb.append("   #").append(i + 1).append(": ").append(wheels[i]).append("\n");
        }
        sb.append("\n").append("=".repeat(50));
        return sb.toString();
    }
}
