package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-06
 * Time: 15:15
 */
public class Demo10 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
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
