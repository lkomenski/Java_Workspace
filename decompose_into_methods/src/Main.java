// This is the main class to test the ArrayUtils methods

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6}; // sumOfEvens should be 12
        int[] array2 = {2, 2, 2}; // countOccurrences target 2 should be 3
        int[] array3 = {}; // empty array test
        int[] array4 = {-2, -1, 0, 3, 4}; // negative and zero test

        System.out.println("Sum of evens in array1: " + ArrayUtils.sumOfEvens(array1));
        System.out.println("Count of 2 in array2: " + ArrayUtils.countOccurrences(array2, 2));
        System.out.println("Sum of evens in array3: " + ArrayUtils.sumOfEvens(array3));
        System.out.println("Sum of evens in array4: " + ArrayUtils.sumOfEvens(array4));
        System.out.println("Count of -1 in array4: " + ArrayUtils.countOccurrences(array4, -1));

        // Testing null array
        int[] nullArray = null;
        System.out.println("Sum of evens in nullArray: " + ArrayUtils.sumOfEvens(nullArray));
        System.out.println("Count of 2 in nullArray: " + ArrayUtils.countOccurrences(nullArray, 2));
    }
    
}
