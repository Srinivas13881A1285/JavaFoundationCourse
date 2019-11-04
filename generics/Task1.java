/*
Task 1. Array operation (15 points)
Create a generic method to swap the positions of two different elements in an array. Array could contain elements of any type
*/

package generics;

public class Task1 {

    public static void main(String[] args) {
        swappingTypes();
    }

    private static void swappingTypes() {
        Object[] inputArray = new Object[2];
        inputArray[0] = "StringType";
        inputArray[1] = 1;
        Object temp = inputArray[0];
        inputArray[0] = inputArray[1];
        inputArray[1] = temp;
    }
}
