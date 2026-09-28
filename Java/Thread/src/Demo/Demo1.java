package Demo;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 9:20
 */
public class Demo1 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(()->{
            System.out.println("t1之前 wait");
            synchronized (locker){
                try{
                    locker.wait();
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
            System.out.println("t1之后 wait");
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2之前 wait");
            synchronized (locker){
                try{
                    locker.wait();
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
            System.out.println("t2之后 wait");
        });

        Thread t3 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入任务内容，唤醒线程");
            scanner.nextInt();
            synchronized (locker){
                locker.notify();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
