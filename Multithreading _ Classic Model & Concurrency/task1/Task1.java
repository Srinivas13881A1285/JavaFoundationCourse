package multithreadingconcurrency.task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        //Map<Integer, Integer> integerIntegerMap = new ConcurrentHashMap<>();

        Runnable addElementIntoMap = () -> {
            for (int i = 1; i <= 10000; i++) {
                integerIntegerMap.put(i, i);
            }
        };

        Runnable doMapElementsSum = () -> {
            int total = 0;
            for (Map.Entry m : integerIntegerMap.entrySet()) {
                int element = (int) m.getValue();
                total += element;
            }
            System.out.println("total = " + total);
        };

        Thread threadOne = new Thread(addElementIntoMap);
        Thread threadTwo = new Thread(doMapElementsSum);
        threadOne.start();
        threadTwo.start();



    }


}

;