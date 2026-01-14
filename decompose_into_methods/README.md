# Integer Array Utility (Java)

## Overview
This project contains a small utility class that analyzes integer arrays using single-responsibility methods.

## Methods

### `sumOfEvens(int[] nums)`
Returns the sum of all even numbers in the array.
- If `nums` is `null` or empty, returns `0`.
- Includes negative even numbers and zero.

Example:
- `sumOfEvens([1, 2, 3, 4, 5, 6])` returns `12`

### `countOccurrences(int[] nums, int target)`
Returns how many times `target` appears in the array.
- If `nums` is `null` or empty, returns `0`.

Example:
- `countOccurrences([2, 2, 2], 2)` returns `3`

## Debugger Observations (VS Code)
1. The enhanced for-loop ran once per element in the array. When debugging `array1 = {1,2,3,4,5,6}`, I hit the loop breakpoint 6 times.
2. The loop variable `num` updated each iteration to the next element value.
3. In `sumOfEvens`, `sum` only changed when `num % 2 == 0` was true; odd values skipped `sum += num`.
4. In `countOccurrences`, `count` only incremented when `num == target`. For `{2,2,2}` with target `2`, `count` increased 0 → 1 → 2 → 3.
5. For the empty array case (`{}`), the loop body never executed and the method returned 0.

## How to Run
Run `Main.java` to see sample outputs for normal and edge cases.
