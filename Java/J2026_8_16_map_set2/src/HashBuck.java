/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-16
 * Time: 22:06
 */
public class HashBuck {
    public static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array = new Node[10];
    private int usedSize = 0;
    private static final double DEFAULT_LOAD_FACTOR = 0.75f;

    public void push(int key,int val){
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null){
            if (cur.key == key){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        // 没有找到当前链表中有key节点
        Node node = new Node(key, val);//新建一个节点
        //头插法
        node.next = array[index];
        array[index] = node;

        usedSize++;
        if (doLoadFactor() >= DEFAULT_LOAD_FACTOR){
            resize();
        }
    }

    private void resize() {

        Node[] newArray = new Node[2 * array.length];

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null){
                int newIndex = cur.key % newArray.length;
                Node curN = cur.next; //存下一个节点的位置
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curN;
            }
        }

        array = newArray;
    }

    private double doLoadFactor(){
        return usedSize*1.0 / array.length;
    }

    public int getVal(int key){
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null){
            if (cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}
