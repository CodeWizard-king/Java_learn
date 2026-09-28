package Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-06
 * Time: 12:01
 */
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            // 这个代码是在lambda 中 （也就是 t 线程的入口方法中）调用的
            // 返回的结果就是 t
            // System.out.println(Thread.currentThread().getName());
            while(!Thread.currentThread().isInterrupted()){
               System.out.println("hello Thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   // 这个线程掀桌了
                   // throw new RuntimeException(e);
                   // 加上 break 就是立即终止
                   // 什么都不写 就是不终止
                   // catch 中先执行一些其他逻辑语句在break  就是稍后终止
                   break;
               }
           }
            System.out.println("t 结束");
        });
        t.start();

        Thread.sleep(3000);
        System.out.println("sleep线程尝试终止t线程");
        t.interrupt();

        // 这个代码在 main 方法中调用，此时返回的结果就是 main
        // System.out.println(Thread.currentThread().getName());

    }
}
