package Homework;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-10
 * Time: 8:45
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Object stack = new Object();
        for (int i = 0; i < 10; i++) {

            Thread t1 = new Thread(()->{
                System.out.print("A");
            });

            Thread t2 = new Thread(()->{
                System.out.print("B");
            });

            Thread t3 = new Thread(()->{
                System.out.print("C");
            });
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            System.out.println();
        }

    }
}
