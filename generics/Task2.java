/*Task 2.
Generic method and type bounds (20 points)
Create a generic method to find the maximal element in the range [begin, end) of a list.
The list could be parametrized by any type, but the list’s elements should be comparable, of course.*/
package generics;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static <T extends Comparable<T>> T maximum(List<T> list, int begin, int end) {
        T max = list.get(begin);
        for (T element : list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 14, 5, 6, 7);
        Integer maximum = maximum(integers, 0, 8);
        System.out.println("maximum = " + maximum);


        List<String> strings = Arrays.asList("Apple", "Orange", "Banana", "Z");
        String maximum1 = maximum(strings, 0, 2);
        System.out.println("maximum1 = " + maximum1);

        List<Double> doubles = Arrays.asList(1.0, 0.1, 1.3);
        Double maximum2 = maximum(doubles, 0, 2);
        System.out.println("maximum2 = " + maximum2);
    }


}
