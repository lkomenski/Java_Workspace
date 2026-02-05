import java.util.ArrayList;

public class ArraysArrayList {

    public static void main(String[] args) {

        // ----------------------------
        // Arrays vs ArrayList
        // ----------------------------

        // int[] array with 5 numbers
        int[] numbersArray = { 1, 2, 3, 4, 5 };

        System.out.println("Array elements:");
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println(numbersArray[i]);
        }
        System.out.println("Array length: " + numbersArray.length);

        // ArrayList<Integer> with same 5 numbers
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);

        System.out.println("\nArrayList elements:");
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(numbersList.get(i));
        }
        System.out.println("ArrayList size: " + numbersList.size());

        // Try to "grow" the array
        // numbersArray[5] = 6; // Not allowed — arrays have a fixed size once created

        // Grow the ArrayList
        numbersList.add(6);
        System.out.println("\nArrayList after adding another number:");
        System.out.println(numbersList);
        System.out.println("\nArrayList size after adding another number: " + numbersList.size());

        // Array is best when the size is fixed and known.
        // ArrayList is best when the size may change/is unknown.

        // ----------------------------
        // Generics (Type Safety)
        // ----------------------------

        ArrayList<String> names = new ArrayList<>();
        names.add("Leena");
        names.add("Ana");
        names.add("Marcus");

        // names.add(10); // Not allowed — ArrayList<String> can only store String values

        // ----------------------------
        // Iteration Patterns
        // ----------------------------

        System.out.println("\nIterating int[] with for loop:");
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println(numbersArray[i]);
        }

        System.out.println("\nIterating int[] with for-each loop:");
        for (int num : numbersArray) {
            System.out.println(num);
        }

        System.out.println("\nIterating ArrayList with for loop:");
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(numbersList.get(i));
        }

        System.out.println("\nIterating ArrayList with while loop:");
        int index = 0;
        while (index < numbersList.size()) {
            System.out.println(numbersList.get(index));
            index++;
        }
    }
}