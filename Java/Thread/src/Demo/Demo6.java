package Demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-13
 * Time: 14:19
 */

class MyThreadPool{
    private BlockingQueue<Runnable> queue = null;

    // 初始化线程池
    public MyThreadPool(int n){
        // 创建一个容量为1000的阻塞队列
        queue = new ArrayBlockingQueue<>(1000);
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(()->{
                try {
                    while (true){
                        Runnable task = queue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
public class Demo6 {

}
