package Homework;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 10:48
 */
public class Demo6 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread a = new Thread(()->{
            try{
                synchronized (locker1){
                    locker1.wait();
                }
                System.out.println(Thread.currentThread().getName());
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });
        Thread b = new Thread(()->{
            try{
                synchronized (locker2){
                    locker2.wait();
                }
                System.out.println(Thread.currentThread().getName());
                synchronized (locker1){
                    locker1.notify();
                }
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });
        Thread c = new Thread(()->{
            try{
                synchronized (locker3){
                    locker3.wait();
                }
                System.out.println(Thread.currentThread().getName());
                synchronized (locker2){
                    locker2.notify();
                }
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });
        a.setName("a");
        b.setName("b");
        c.setName("c");
        a.start();
        b.start();
        c.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (locker3){
            locker3.notify();
        }
    }
}
