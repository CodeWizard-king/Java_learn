package Homework;

import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-13
 * Time: 13:17
 */

class MyBlockingQueue{
    private static String data[];

    public MyBlockingQueue(int capacity){
        data = new String[capacity];
    }

    private static int head = 0;
    private static int tail = 0;
    private static int size = 0;

    public void put(String elem) throws InterruptedException {
        synchronized (this){
            while (size == data.length){
                this.wait();
            }
            data[tail] = elem;
            tail++;
            if (tail >= data.length){
                tail = 0;
            }
            size++;
            this.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this){
            while (size == 0){
                this.wait();
            }
            String t = data[head];
            head++;
            if (head >= data.length){
                head = 0;
            }
            size--;
            this.notify();
            return t;
        }
    }
}
public class Demo8 {
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    myBlockingQueue.put(i + "");
                    System.out.println("生产者：" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    String t = myBlockingQueue.take();
                    System.out.println("消费者：" + t);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
