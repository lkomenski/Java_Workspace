package carparts;

import exceptions.InvalidWheelSpecException;

/**
 * Represents a car wheel with size and pressure.
 */
public class Wheel {
    private double size;
    private double pressure;

    /**
     * Creates a Wheel with specified size and pressure.
     * Precondition: size > 0, pressure >= 0
     * Postcondition: Wheel object is created with valid values
     */
    public Wheel(double size, double pressure) {
        setSize(size);
        setPressure(pressure);
    }

    /**
     * Sets the size of the wheel.
     * Precondition: size > 0 and size <= 60
     * Postcondition: size is assigned and valid
     */
    public void setSize(double size) {
        if (size <= 0) {
            throw new InvalidWheelSpecException("Wheel size must be greater than 0.");
        }
        if (size > 60) {
            throw new InvalidWheelSpecException("Wheel size cannot exceed 60 inches.");
        }
        this.size = size;
    }

    /**
     * Sets the pressure of the wheel.
     * Precondition: pressure >= 0 and pressure <= 55
     * Postcondition: pressure is assigned and valid
     */
    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new InvalidWheelSpecException("Wheel pressure cannot be negative.");
        }
        if (pressure > 50) {
            throw new InvalidWheelSpecException("Your tire pressure should never be that high! Please fix.");
        }
        this.pressure = pressure;
    }

    /**
     * Gets the size of the wheel.
     * Precondition: none
     * Postcondition: returns the wheel size
     */
    public double getSize() {
        return size;
    }

    /**
     * Gets the pressure of the wheel.
     * Precondition: none
     * Postcondition: returns the wheel pressure
     */
    public double getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "Size: " + size + ", Pressure: " + pressure + " PSI";
    }
}
