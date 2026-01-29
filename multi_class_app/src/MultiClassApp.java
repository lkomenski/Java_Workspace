import java.util.Scanner;
import carparts.*;
import exceptions.*;

/**
 * Main program that demonstrates car composition.
 * Asks user for input and builds a Car object with Engine, Wheels, and Driver.
 */
public class MultiClassApp {

    public static void main(String[] args) {
        System.out.println("=== Car Builder ===");

        try (Scanner sc = new Scanner(System.in)) {

            Engine engine = buildEngine(sc);
            Wheel[] wheels = buildWheels(sc);
            Driver driver = buildDriver(sc);

            Car car = new Car(engine, wheels, driver);
            
            // Display formatting (success)
            System.out.println("\n" + "=".repeat(50));
            System.out.println("CAR ASSEMBLED SUCCESSFULLY!");
            System.out.println("=".repeat(50));
            System.out.println(car);

        // Handle exceptions and display error messages
        } catch (InvalidWheelCountException e) {
            System.out.println("Car assembly error: " + e.getMessage());
        } catch (InvalidEngineException e) {
            System.out.println("Engine error: " + e.getMessage());
        } catch (InvalidDriverException e) {
            System.out.println("Driver error: " + e.getMessage());
        } catch (InvalidWheelSpecException e) {
            System.out.println("Wheel specification error: " + e.getMessage());
        } catch (InvalidSpecException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    /**
     * Builds an Engine by getting user input.
     * Precondition: Scanner is initialized and ready
     * Postcondition: Returns a valid Engine object
     */
    private static Engine buildEngine(Scanner sc) throws InvalidEngineException {
        int hp = 0;
        String type = "";
        
        // Get horsepower first and validate it
        while (true) {
            try {
                System.out.print("Enter engine horsepower: ");
                hp = Integer.parseInt(sc.nextLine());
                
                if (hp <= 0) {
                    System.out.println("Horsepower must be positive.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        // Get engine type and validate it
        while (true) {
            try {
                System.out.print("Enter engine type (e.g., V6, V8, Electric): ");
                type = sc.nextLine();
                
                if (type == null || type.isBlank()) {
                    System.out.println("Engine type cannot be blank.");
                    continue;
                }
                
                // Check if type contains at least one letter
                if (!type.matches(".*[a-zA-Z].*")) {
                    System.out.println("Engine type must contain at least one letter.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
        
        return new Engine(hp, type);
    }

    /**
     * Builds an array of 4 Wheels by getting user input.
     * Precondition: Scanner is initialized and ready
     * Postcondition: Returns an array of 4 valid Wheel objects
     */
    private static Wheel[] buildWheels(Scanner sc) {
        Wheel[] wheels = new Wheel[4];

        for (int i = 0; i < wheels.length; i++) {
            double size = 0;
            double pressure = 0;
            
            // Get wheel size and validate it
            while (true) {
                try {
                    System.out.print("Enter size for wheel " + (i + 1) + " (inches): ");
                    size = Double.parseDouble(sc.nextLine());
                    
                    if (size <= 0) {
                        System.out.println("Wheel size must be greater than 0.");
                        continue;
                    }
                    
                    if (size > 60) {
                        System.out.println("Wheel size cannot exceed 60 inches.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
            
            // Get wheel pressure and validate it
            while (true) {
                try {
                    System.out.print("Enter pressure for wheel " + (i + 1) + " (PSI): ");
                    pressure = Double.parseDouble(sc.nextLine());
                    
                    if (pressure < 0) {
                        System.out.println("Wheel pressure cannot be negative.");
                        continue;
                    }
                    
                    if (pressure > 55) {
                        System.out.println("Your tire pressure should never be that high! Please deflate and try again at an appropriate pressure.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
            
            wheels[i] = new Wheel(size, pressure);
        }
        return wheels;
    }

    /**
     * Builds a Driver by getting user input.
     * Precondition: Scanner is initialized and ready
     * Postcondition: Returns a valid Driver object
     */
    private static Driver buildDriver(Scanner sc) throws InvalidDriverException {
        String name = "";
        int age = 0;
        
        // Get driver name and validate it
        while (true) {
            System.out.print("Enter driver name: ");
            name = sc.nextLine();
            
            if (name == null || name.isBlank()) {
                System.out.println("Driver name cannot be blank.");
                continue;
            }
            break;
        }
        
        // Get driver age and validate it
        while (true) {
            try {
                System.out.print("Enter driver age: ");
                age = Integer.parseInt(sc.nextLine());
                
                if (age < 16) {
                    System.out.println("Driver must be at least 16 years old.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        return new Driver(name, age);
    }
}
