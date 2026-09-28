package Thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-09-06
 * Time: 15:51
 */
public class Demo6_Homework {
    private static final int Array_length = 10_000_000;
    private static long oddIndexSum = 0;
    private static long evenIndexSum = 0;

    public static void main(String[] args) throws InterruptedException {
        // 记录开始时间
        long stark = System.currentTimeMillis();

        int[] arr = new int[Array_length];
        for (int i = 0; i < Array_length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1,101);
        }


        Thread odd = new Thread(()->{
            long sum = 0;
            for (int i = 1; i < Array_length; i+=2) {
                sum += arr[i];
            }
            oddIndexSum = sum;
        });


        Thread even = new Thread(()->{
            long sum = 0;
            for (int i = 0; i < Array_length; i+=2) {
                sum += arr[i];
            }
            evenIndexSum = sum;
        });

        odd.start();
        even.start();

        odd.join();
        even.join();

        long total = oddIndexSum + evenIndexSum;
        long end = System.currentTimeMillis();

        System.out.println("奇数下标之和：" + oddIndexSum);
        System.out.println("偶数下标之和：" + evenIndexSum);
        System.out.println("数组元素之和：" + total);
        System.out.println("执行时间：" + (end-stark) + "ms");
    }
}
