package Demo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-13
 * Time: 18:05
 */

// 定时任务类
class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable task; // 要执行的任务
    private long time = 0; // 执行时间

    public MyTimerTask(Runnable task, long time) {
        this.task = task;
        this.time = time;
    }

    // 按执行时间排序，时间早的先执行
    @Override
    public int compareTo(MyTimerTask o) {
        return Long.compare(this.time, o.time);
    }

    // 获取执行时间
    public long getTime(){
        return this.time;
    }

    // 执行任务
    public void run(){
        task.run();
    }
}

// 定时器调度核心
class MyTimer {
    // 任务队列
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 任务锁
    private Object locker = new Object();

    // 提交任务：delay 多少毫秒之后执行
    public void schedule(Runnable task, long delay) {
        synchronized (locker) {
            MyTimerTask timerTask = new MyTimerTask(task, System.currentTimeMillis() + delay);
            queue.offer(timerTask);
            locker.notify(); // 唤醒等待的线程
        }
    }

    public MyTimer() {
        // 调度线程，死循环不断检查任务队列
        Thread t = new Thread(()->{
           try{
               while (true){
                   synchronized (locker){
                       // ① 如果队列为空，一直等待新任务
                       while (queue.isEmpty()){
                           locker.wait();
                       }
                       // 取出一个任务
                       MyTimerTask task = queue.peek();
                       // 获取当前时间
                       long nowTime = System.currentTimeMillis();
                       if (nowTime < task.getTime()){
                           // 任务还没到时间，等待剩余时间
                           locker.wait(task.getTime() - nowTime);
                       } else {
                           // 时间到！执行任务，把任务从队列删掉
                           task.run();
                           queue.poll();
                       }
                   }
               }
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });
        t.start();
    }
}
public class Demo7_time {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        System.out.println("开始");
        timer.schedule(() -> System.out.println("任务1，延迟2s"), 2000);
        timer.schedule(() -> System.out.println("任务2，延迟1s"), 1000);
    }
}
