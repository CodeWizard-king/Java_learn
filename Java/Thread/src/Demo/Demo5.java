package Demo;

import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-12
 * Time: 19:59
 */

class MyBlockingQueue{
    private static String date[];

    private  int head = 0;
    private int tail = 0;

    private int size = 0;

    public MyBlockingQueue(int capacity){
        date = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (this){
            while (size >= date.length){
                this.wait();
            }
            date[tail] = elem;
            tail++;
            if (tail >= date.length){
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
            String t = date[head];
            head++;
            if (head >= date.length){
                head = 0;
            }
            size--;
            this.notify();
            return t;
        }
    }
}
public class Demo5 {

    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);
        Thread producer = new Thread(()->{
            int n = 0;
            while (true){
                try {
                    myBlockingQueue.put(n + " ");
                    System.out.println("生产者：" + n);
                    n++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            while (true){
                try {
                    String t = myBlockingQueue.take();
                    System.out.println("消费者：" + t);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
