// Observations are contained in the README.md file.

public class ArrayUtils {

    // Returns the sum of all even numbers in the given array.
    // Edge cases: null or empty
    public static int sumOfEvens(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int sum = 0;

        // Breakpoint #1: set breakpoint on next line (the loop)
        for (int num : nums) {
            // Breakpoint #2: set breakpoint on next line (the if statement)
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    // Returns the count of occurrences of target in the given array.
    // Edge cases: null or empty
    public static int countOccurrences(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        int count = 0;

        // Breakpoint #1: set breakpoint on next line (the loop)
        for (int num : nums) {
            // Breakpoint #2: set breakpoint on next line (the if statement)
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
