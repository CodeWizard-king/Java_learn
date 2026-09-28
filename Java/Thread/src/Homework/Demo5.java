package Homework;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-10
 * Time: 8:52
 */
public class Demo5 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(()->{
            synchronized (locker1){
                System.out.println("线程1 获取到 lockerA");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
                System.out.println("线程1 等待获取 lockerB");
                synchronized (locker2){
                    System.out.println("线程1 获取到 lockerB");
                }
            }
        },"lockerA");

        Thread t2 = new Thread(()->{
           synchronized (locker2){
               System.out.println("线程2 获取到 lockerB");
               try {
                   Thread.sleep(1000);
               }catch (InterruptedException e){
                   throw new RuntimeException();
               }
                System.out.println("线程2 等待获取 lockerA");
                synchronized (locker1) {
                    System.out.println("线程2 获取到 lockerA");
                }
           }
        },"lockerB");
        t1.start();
        t2.start();
    }
}
