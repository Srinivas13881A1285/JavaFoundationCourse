package lamdas;

import java.util.function.Predicate;

public class Task4 {
    public static void main(String[] args) {
        CustomFunctionalInterface<Integer,Double,Boolean,String> customFunctionalInterface = Task4::passThrough;

        Predicate<String> predicate = text -> text.contains("srinivas");

        String srinivas = customFunctionalInterface.someMethod(10, 50.0, true);

        System.out.println("srinivas = " + srinivas);

        
        CustomFunctionalInterface<String,Integer,Double,Boolean> customFunctionalInterface1 = Task4::passThrough2;
        Boolean srinivas1 = customFunctionalInterface1.someMethod("Srinivas", 100, 100.0);
        System.out.println("srinivas1 = " + srinivas1);
    }

    private static Boolean passThrough2(String s, Integer integer, Double aDouble) {
        return true;
    }
    

    private static String passThrough(Integer text, Double deci, Boolean bool) {
        return  "Hello  World";
    }
}

@FunctionalInterface
interface CustomFunctionalInterface<T,R,V,K> {
    abstract K someMethod(T arg1, R arg2, V arg3);
}