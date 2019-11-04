/*Task 5. Auto-grow (10 points)
Implement auto-grow functionality: when the internal array is 75% full, create a new array of double size and move all
 elements to it.*/
package generics;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        //String
        CustomListAutoGrow<String> integerCustomList = new CustomListAutoGrow<>(3);
        System.out.println(integerCustomList.size());
        integerCustomList.add("1");
        integerCustomList.add("2");
        System.out.println(integerCustomList.size());
        integerCustomList.add("3");
        integerCustomList.add("4");
        System.out.println(integerCustomList.size());


    }
}

class CustomListAutoGrow<T> {

    private int size;

    private int pointer = -1;

    Object[] inputArray;

    public CustomListAutoGrow(int size) {
        this.size = size;
        inputArray = new Object[size];
    }

    void add(T element) {
        double percentage = (pointer + 1) * 100 / size;
        if (percentage >= 75) {
            size = size * 2;
            inputArray = Arrays.copyOf(inputArray, size);
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
