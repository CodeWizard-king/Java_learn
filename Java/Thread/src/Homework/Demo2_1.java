package Homework;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 10:09
 */
public class Demo2_1 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread t1 = new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized (locker1){
                        locker1.wait();
                    }
                    System.out.print("A");
                    synchronized (locker2){
                        locker2.notify();
                    }
                }
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized (locker2){
                        locker2.wait();
                    }
                    System.out.print("B");
                    synchronized (locker3){
                        locker3.notify();
                    }
                }
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
        });

        Thread t3 = new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized (locker3){
                        locker3.wait();
                    }
                    System.out.println("C");
                    synchronized (locker1){
                        locker1.notify();
                    }
                }
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (locker1){
            locker1.notify();
        }
    }
}
