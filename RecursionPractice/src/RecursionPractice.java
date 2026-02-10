public class RecursionPractice {

    // Returns the factorial of n using recursion
    public static int factorial(int n) {
        // Base case: when n is 0, stop recursion and return 1
        if (n == 0) {
            return 1;
        }

        // Recursive case: multiply n by factorial of (n - 1)
        // Each call moves closer to the base case by decreasing n
        return n * factorial(n - 1);
    }

    // Returns the sum of all elements in the array using recursion
    public static int sumArray(int[] arr, int index) {
        // Base case: when index reaches the end of the array, stop recursion
        if (index == arr.length) {
            return 0;
        }

        // Recursive case: add the current element to the sum of the rest
        // Each call moves closer to the base case by increasing index
        return arr[index] + sumArray(arr, index + 1);
    }

    // Returns the nth Fibonacci number using recursion
    public static int fibonacci(int n) {
        // Base cases: stop recursion when n is 0 or 1
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Recursive case: sum of the two previous Fibonacci numbers
        // Each call moves closer to the base cases by reducing n
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Test factorial
        System.out.println("Factorial of 5: " + factorial(5));

        // Test sumArray
        int[] numbers = {2, 4, 6, 8};
        System.out.println("Sum of array: " + sumArray(numbers, 0));

        // Test fibonacci
        System.out.println("Fibonacci of 7: " + fibonacci(7));
    }
}