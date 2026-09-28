package Homework;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-10
 * Time: 8:40
 */
public class Demo1 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(count);
    }
}
