/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-10
 * Time: 16:40
 */
public class Test {
    public static void main(String[] args) {
        int[] array= new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        MyPriorityQueue myPriorityQueue=new MyPriorityQueue();
        myPriorityQueue.initElem(array);
        myPriorityQueue.createHeap();
        myPriorityQueue.offer(80);
    }
}
