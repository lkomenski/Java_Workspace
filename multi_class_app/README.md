# Multi-Class Car Builder

A Java program that builds a Car using composition with Engine, Wheels, and Driver components. Demonstrates packages, encapsulation, and exception handling.

## Structure

```
src/
├── MultiClassApp.java           # Main program
├── carparts/                    # Car components package
│   ├── Car.java
│   ├── Engine.java
│   ├── Wheel.java
│   └── Driver.java
└── exceptions/                  # Custom exceptions package
    ├── InvalidSpecException.java
    ├── InvalidWheelSpecException.java
    ├── InvalidEngineException.java
    ├── InvalidDriverException.java
    └── InvalidWheelCountException.java
```

## Key Features

- **Composition**: Car contains Engine, Wheel array, and Driver
- **Encapsulation**: Private fields with getters/setters
- **Validation**: Input checking with exceptions
- **Packages**: Organized into `carparts` and `exceptions`

## Validation Rules

- Engine horsepower > 0, type must contain letters
- Wheel size: 0-60 inches, pressure: 0-55 PSI
- Car must have exactly 4 wheels
- Driver name auto-capitalizes, age ≥ 16

## Exceptions

**Checked (must catch):**
- `InvalidWheelCountException`
- `InvalidEngineException`
- `InvalidDriverException`

**Unchecked (runtime):**
- `InvalidSpecException`
- `InvalidWheelSpecException`

## How to Run

```bash
javac -d bin src/**/*.java src/*.java
java -cp bin MultiClassApp
```



