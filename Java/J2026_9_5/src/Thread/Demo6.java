package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-05
 * Time: 16:00
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            while (true){
                System.out.println("hello t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(() ->{
            while (true){
                System.out.println("hello t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t2");
        t2.start();

        Thread t3 = new Thread(() ->{
            while (true){
                System.out.println("hello t3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t3");
        t3.start();
    }
}
