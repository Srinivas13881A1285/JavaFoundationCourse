package multithreadingconcurrency.task1;

import java.util.*;

public class SynchronizedMap {
    public static void main(String[] args) {

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        Map<Integer,Integer> map = Collections.synchronizedMap(integerIntegerMap);

        Runnable addElement = () -> {
            for (int i = 1;i<=1000;i++) {
                synchronized (map) {
                    map.put(i, i);
                }
            }
        };
        Thread threadOne = new Thread(addElement);

        Runnable sumUp = () -> {
            int syncTotal = 0;
            Set set = map.entrySet();
           synchronized (map) {
                Iterator i = set.iterator();
                while (i.hasNext()) {
                    Map.Entry me = (Map.Entry) i.next();
                    syncTotal += (int) me.getValue();
                }
           }
            System.out.println("syncTotal = " + syncTotal);
        };


        Thread threadTwo = new Thread(sumUp);
        threadOne.start();
        threadTwo.start();


    }
}
