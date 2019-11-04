/*Task 1. (5 points) A bit of concurrency
    Create several instances of Runnable interface with different behavior using lambda expressions.
    Run these lambdas via Thread API.
*/
package lamdas;

public class Task1 {
    public static void main(String[] args) {

        Runnable task1 = () -> System.out.println("task1 started");
        Runnable task2 = () -> System.out.println("task2 started");
        Runnable task3 = () -> System.out.println("task3 started");

        Thread thread1, thread2, thread3;

        thread1 = new Thread(task1);
        thread2 = new Thread(task2);
        thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
