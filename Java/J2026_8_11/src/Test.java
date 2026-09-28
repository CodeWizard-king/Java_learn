import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Spliterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-11
 * Time: 11:52
 */
class IntCmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1,Integer o2) {
        return o2.compareTo(o1);
    }
}
public class Test {

    public int[] smallestK(int[] arr, int k) {
        int[] ret=new int[k];
        if (k==0){
            return ret;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(k,new IntCmp());
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int peekVal=priorityQueue.peek();
            if (peekVal>arr[i]){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i]=priorityQueue.poll();
        }
        return ret;
    }

    public int[] smallestK1(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        int[] ret=new int[k];
        for (int i = 0; i < k; i++) {
            ret[i]=priorityQueue.poll();
        }
        return ret;
    }

    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new IntCmp());
        priorityQueue.offer(11);
        priorityQueue.offer(20);
        System.out.println(priorityQueue.peek());
    }
}
