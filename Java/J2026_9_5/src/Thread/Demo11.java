package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-06
 * Time: 15:39
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {

        Thread mainThread = Thread.currentThread();

        Thread t = new Thread(()->{
            try {
                mainThread.join();
                System.out.println("子线程：主线程已经结束，我开始工作");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        System.out.println("主线程启动");
        Thread.sleep(3000);
        System.out.println("主线程结束");
    }
}
