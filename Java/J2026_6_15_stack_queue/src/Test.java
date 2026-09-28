/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-22
 * Time: 19:24
 */
public class Test {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(5);
        myQueue.offer(6);
        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
    }
}
