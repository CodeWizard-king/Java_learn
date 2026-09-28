package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-06
 * Time: 10:11
 */

class MyRunnable implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("hello Runnable");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();

        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
