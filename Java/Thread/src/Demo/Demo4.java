package Demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 19:35
 */
public class Demo4 {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1000);

        Thread user = new Thread(()->{
            int n = 0;
           while (true){
               try {
                   blockingQueue.put(n);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               n++;
           }
        });

        Thread server = new Thread(()->{
            while (true){
                try {
                    Integer n = blockingQueue.take();
                    System.out.println(n);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        user.start();
        server.start();
    }
}
