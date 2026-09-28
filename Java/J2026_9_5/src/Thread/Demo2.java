package Thread;

import java.awt.image.ImagingOpException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-05
 * Time: 14:55
 */

class  MyRunnable implements Runnable{
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
        Runnable runnable =new MyRunnable();
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
