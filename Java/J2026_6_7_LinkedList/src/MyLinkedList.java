/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-13
 * Time: 20:19
 */
public class MyLinkedList implements IList{

    public class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val){
            this.val=val;
        }
    }

    public ListNode head;
    public ListNode last;

    @Override
    public void addFirst(int data) {
        ListNode node=new ListNode(data);
        if(head==null){
            head=last=node;
        } else {
            node.next=head;
            head.prev=node;
            head=node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node=new ListNode(data);
        if (head==null){
            head=last=node;
        } else {
            node.prev=last;
            last.next=node;
            last=node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        int len=size();
        if(index<0 && index>len){
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==len){
            addLast(data);
            return;
        }
        ListNode cur=findIndex(index);
        ListNode node=new ListNode(data);
        node.next=cur;
        node.prev=cur.prev;
        cur.prev.next=node;
        cur.prev=node;
    }


    private ListNode findIndex(int index){
        ListNode cur=head;
        while (index!=0){
            index--;
            cur=cur.next;
        }
        return cur;
    }

    @Override
    public void remove(int key) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==key){
                if (cur.prev == null) {
                    head=head.next;
                    if(head!=null){
                        head.prev=null;
                    }else{
                        last=null;
                    }
                }
                else if (cur.next == null) {
                    last=last.prev;
                    last.next=null;
                }
                else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                cur.prev = null;
                cur.next = null;
                return;
            }
            cur=cur.next;
        }
    }


    @Override
    public void removeAllKey(int key) {
        if (head==null){
            return;
        }
        ListNode cur=head;
        while(cur!=null){
            ListNode curN=cur.next;
            if(cur.val==key){
                if (cur.prev == null) {
                    head=head.next;
                    if(head!=null){
                        head.prev=null;
                    }else{
                        last=null;
                    }
                }
                else if (cur.next == null) {
                    last=last.prev;
                    last.next=null;
                }
                else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                cur.prev = null;
                cur.next = null;
            }
            cur=curN;
        }
    }



    @Override
    public void clear() {
        ListNode cur=head;
        while (cur!=null){
            ListNode curN = cur.next;
            cur.next=null;
            cur.prev=null;
            cur=curN;
        }
        head=null;
        last=null;
    }

    @Override
    public void display() {
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public int size() {
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
}
