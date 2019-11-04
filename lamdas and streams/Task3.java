/*
Task 3. (10 points) Functional Interface Sandbox
1. Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.) using lambda expressions.
2. Create your own functional interface and add several implementations using both lambda expressions and inner anonymous classes.
3. Add few default methods to it and use them.
4. Add few static methods to it and use them.
 */
package lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> ifEvenNumber = number -> number % 2 == 0;

        integers.stream().filter(ifEvenNumber).forEach(System.out::println);

        Supplier<Boolean> booleanSupplier = () -> "Supplier Functional Interface has get()".length() == 100;
        Supplier<Integer> integerSupplier = () -> "Supplier Functional Interface has get()".length();
        Supplier<String> stringSupplier = () -> "Supplier Functional Interface has get()".toUpperCase();


        BinaryOperator<Integer> sumOfNumbers = (sum, number) -> sum + number;
        Integer reduce = integers.stream().reduce(0, sumOfNumbers);
        System.out.println("reduce = " + reduce);


        Consumer<Integer> stringConsumer = (e) -> System.out.print(e);
        integers.forEach(stringConsumer);

        Function<Integer, Double> doubleFunction = i -> i * 2.0;
        integers.stream().map(doubleFunction).forEach(System.out::println);

        UnaryOperator<Integer> doubleTheValue = i -> i * 2;
        integers.stream().map(doubleTheValue).forEach(System.out::println);


        Calculator calculator = (a, b) -> a + b;
        Calculator calculator1 = (a, b) -> a * b;

        calculator.print();
        Calculator.printAll();

        Calculator calculator2 = new Calculator() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        Calculator calculator3 = new Calculator() {
            @Override
            public int sum(int a, int b) {
                return a * b;
            }
        };


    }
}

@FunctionalInterface
interface Calculator {
    int sum(int a, int b);

    default void print() {
        System.out.println("srinivas");
    }

    static void printAll() {
        System.out.println("all");
    }
}