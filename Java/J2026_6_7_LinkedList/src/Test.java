/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-07
 * Time: 9:48
 */
public class Test {

    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addLast(3);
        myLinkedList.addLast(3);
        myLinkedList.removeAllKey(3);
        myLinkedList.display();
    }

    public MySingleList.ListNode mergeTwoLists(MySingleList.ListNode list1, MySingleList.ListNode list2) {
        MySingleList.ListNode newHad=new MySingleList.ListNode(-1);
        MySingleList.ListNode tmp = newHad;
        while(list1!=null && list1!=null){
            if(list1.val< list2.val){
                tmp.next=list1;
                list1=list1.next;
                tmp=tmp.next;
            }else{
                tmp.next=list2;
                list2=list2.next;
                tmp=tmp.next;
            }
        }
        if(list1!=null){
            tmp.next=list1;
        }
        if(list2!=null){
            tmp.next=list2;
        }
        return newHad;
    }

    public static void main2(String[] args) {

    }


    public static void main1(String[] args) {
        MySingleList mySingleList=new MySingleList();
        mySingleList.addFirst(23);
        mySingleList.addFirst(23);
        mySingleList.addFirst(23);
        mySingleList.addFirst(4);
        mySingleList.addFirst(23);
        mySingleList.display();
        System.out.println(mySingleList.contains(23));
        //mySingleList.clear();
    }
}
