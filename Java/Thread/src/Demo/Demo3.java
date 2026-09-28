package Demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 19:17
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(100);
        for (int i = 0; i < 100; i++) {
            blockingQueue.put("aaa");
        }
        System.out.println("put成功");
        blockingQueue.put("aaa");
        System.out.println("put失败");
    }
}
