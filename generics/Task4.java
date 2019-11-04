/*Task 4. Min & Max (10 points)
1. Create generic methods Min () and Max () for finding the minimal and maximal element in the CustomList.
2. You may need to add a generic constraint for the type T.*/

package generics;

public class Task4 {
    public static void main(String[] args) {
        CustomList<Integer> integerCustomList = new CustomList<>(2);
        integerCustomList.add(10);
        integerCustomList.add(20);
        System.out.println(maximum(integerCustomList));
        System.out.println(minimum(integerCustomList));
    }

    public static <T extends Comparable<T>> T maximum(CustomList<T> customList) {
        T max = customList.get(0);

        for (int i = 0; i < customList.size(); i++) {
            if (customList.get(i) != null && customList.get(i).compareTo(max) > 0) max = customList.get(i);
        }
        return max;
    }

    public static <T extends Comparable<T>> T minimum(CustomList<T> customList) {
        T min = customList.get(0);
        for (int i = 0; i < customList.size(); i++) {
            if (customList.get(i) != null && customList.get(i).compareTo(min) < 0) min = customList.get(i);
        }
        return min;
    }
}
