/*Task 3.
Custom List (20 points)
1. Create a generic class CustomList that keeps a list of elements of some parametric type T.
2. Keep the elements of the list in an array with fixed capacity which is given as parameter in the class constructor.
3. Implement methods for adding element, accessing element by index, removing element by index, inserting element at
    given position,clearing the list, finding element by its value and override ToString().
4. Check all input parameters to avoid accessing elements at invalid positions.*/
package generics;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

        CustomList<String> stringCustomList = new CustomList<>(3);
        stringCustomList.add("1");
        stringCustomList.add("2");
        stringCustomList.insert(0, "1.5");
        String firstElement = stringCustomList.get(0);
        System.out.println("s = " + firstElement);
        System.out.println(stringCustomList);
        stringCustomList.remove(2);
        System.out.println(stringCustomList);
        stringCustomList.clear();
        System.out.println(stringCustomList);
    }
}

class CustomList<T> {

    private int size;

    private int pointer = -1;

    Object[] inputArray;

    public CustomList(int size) {
        this.size = size;
        inputArray = new Object[size];
    }

    void add(T element) {
        if (pointer >= size - 1) {
            throw new RuntimeException("Size Overflow");
        }
        inputArray[++pointer] = element;
    }

    void insert(int pos, T element) {

        if (pos < 0 && pos >= size) {
            throw new RuntimeException("Invalid Position");
        }

        for (int i = size - 2; i >= pos; i--) {
            inputArray[i + 1] = inputArray[i];
        }
        inputArray[pos] = element;
        if (pointer != size - 1) {
            pointer++;
        }

    }

    T get(int index) {
        if (index < 0 && index >= size) throw new RuntimeException("Invalid index");
        return (T) inputArray[index];
    }

    void remove(int index) {
        if (index < 0 && index >= size) {
            throw new RuntimeException("Invalid Index");
        }

        for (int i = index; i < size; i++) {
            if (i + 1 < size) inputArray[i] = inputArray[i + 1];
            else if (i == size - 1) inputArray[i] = null;
        }
    }


    void clear() {
        inputArray = null;
    }


    int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "inputArray=" + Arrays.toString(inputArray);
    }
}
