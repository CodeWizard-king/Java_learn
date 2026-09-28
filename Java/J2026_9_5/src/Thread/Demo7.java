package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-05
 * Time: 17:07
 */
public class Demo7 {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
           while (true){
               System.out.println("hello Thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        // 必须在start之前
        t.isDaemon();
        t.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
