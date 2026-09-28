import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-07
 * Time: 9:48
 */
public class MySingleList implements IList{

    static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;

    @Override
    public void display() {
        //遍历链表
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void addFirst(int data) {
        //头插法
        ListNode node=new ListNode(data);
        node.next=head;
        head=node;
    }

    @Override
    public void addLast(int data) {
        //尾插法
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
            return;
        }
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.val=data;
    }

    @Override
    public void addIndex(int index, int data) {
        //在任意位置插入
        int len=size();
        if(index<0||index>len){
            System.out.println("插入位置不合法！");
        }
        //前插
        addFirst(data);
        //尾插
        addLast(data);
        //插中间
        ListNode cur=head;
        while (index-1>=0){
            cur=cur.next;
            index--;
        }
        ListNode node=new ListNode(data);
        node.next=cur.next;
        cur.next=node;

    }

    @Override
    public boolean contains(int key) {
        if (head==null){
            return false;
        }
        ListNode node=head;
        while(node!=null){
            if(node.val==key){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int key) {
        //删除指定元素
        if(head==null){
            return;
        }
        if(head.val==key){
            head=head.next;
        }

        ListNode cur=findNodeOfKey(key);
        if(cur==null){
            return;
        }
        ListNode del=cur.next;
        cur.next=del.next;
    }

    private ListNode findNodeOfKey(int key){
        ListNode cur=head;
        while (cur.next!=null){
            if(cur.next.val==key)
                return cur;
            cur=cur.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        //删除数组所有指定元素
        if(head==null){
            return;
        }
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(head.val==key){
            ListNode node=head.next;
            head.next=null;
            head= node;
        }
    }

    @Override
    public int size() {
        ListNode cur=head;
        int len=0;
        while (cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }

    @Override
    public void clear() {
        //清空链表
        ListNode cur=head;
        while(cur!=null){
            ListNode curN=cur.next;
            cur.next=null;
            cur=curN;
        }
    }

    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur=head;
        while(cur != null){
            if(cur.val < x){
                if(bs == null){
                    bs = be = cur;
                }else{
                    be.next=cur;
                    be=be.next;
                }
            }else{
                if(as == null){
                    as=ae=cur;
                }else{
                    ae.next=cur;
                    ae=ae.next;
                }
            }
            cur=cur.next;
        }
        if(bs!=null){
            return as;
        }
        be.next=as;
        if(as!=null){
            ae.next=null;
        }
        return bs;
    }


    public boolean chkPalindrome(){
        if(head==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next;
        while(fast != null &&  fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode cur=slow.next;
        while(cur != null){
            ListNode curN=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curN;
        }

        while(head != slow){
            if(head.val!= slow.val){
                return false;
            }
            if(head.next==slow){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    }

}
