import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-22
 * Time: 19:01
 */
public class MyQueue {

    private class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode fist=null;
    ListNode last=null;
    public int usedSize;

    public void offer(int val){
        ListNode listNode=new ListNode(val);
        if(isEmpty()){
            fist=last=listNode;
        }else{
           last.next=listNode;
           listNode.prev=fist;
           last=listNode;
        }
        usedSize++;
    }

    public int poll(){
        if(isEmpty()) {
            return -1;
        }
        int emp=fist.val;
        if (fist.next == null) {
            fist = null;
            last = null;
        } else {
            fist.next.prev = null;
            fist = fist.next;
        }
        usedSize--;
        return emp;
    }

    public int peek(){
        if(isEmpty()) {
            return -1;
        }
        return fist.val;
    }

    public int size(){
        return usedSize;
    }
    public boolean isEmpty(){
        if(usedSize==0){
            return true;
        }
        return false;
    }
}
