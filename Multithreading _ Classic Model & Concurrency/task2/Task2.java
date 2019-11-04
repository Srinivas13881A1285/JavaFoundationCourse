package multithreadingconcurrency.task1;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(integers);

        Runnable addRandomNumbers = () -> {
            for(int i = 1;i <= 10000;i++){
                SecureRandom secureRandom = new SecureRandom();
                synchronized (synchronizedList)
                {
                    integers.add(secureRandom.nextInt(100));
                }
            }
        };
        Thread threadOne = new Thread(addRandomNumbers);
        threadOne.start();

        Runnable sumUpIntegers = () -> {
            int sum = 0;
            synchronized (synchronizedList) {
                for(Integer number : integers)
                    sum+=number;
            }
            System.out.println("sum = " + sum);
        };
        Thread threadTwo = new Thread(sumUpIntegers);
        threadTwo.start();


        Runnable squareRoot = () -> {
            int sum = 0;
            double sqrt;
            synchronized (synchronizedList) {
                for(Integer number : integers)
                    sum+=number;
                 sqrt = Math.sqrt(sum);
            }
            System.out.println("sqrt = " + sqrt);
        };
        Thread threadThree = new Thread(squareRoot);
        threadThree.start();

    }
}
