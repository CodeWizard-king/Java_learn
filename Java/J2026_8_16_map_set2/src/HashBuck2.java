/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-18
 * Time: 0:08
 */
public class HashBuck2<K,V> {
    public static class Node<K,V>{
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node<K,V>[] array = (Node<K,V>[]) new Node[10];
    private int usedSize = 0;
    private static final double DEFAULT_LOAD_FACTOR = 0.75f;

    public void push(K key, V val){
        int hashcode = key.hashCode();
        int index = (hashcode % array.length + array.length) % array.length; //考虑负数情况
        Node<K,V> cur = array[index];
        while (cur != null){
            if (cur.key.equals(key)){
                cur.val = val;
                return;
            }
            cur =cur.next;
        }
        Node<K,V> node = new Node<>(key, val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (doLoadFactor() >= DEFAULT_LOAD_FACTOR){
            resize();
        }
    }

    private void resize() {
        Node<K,V>[] newArray = new Node[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = array[i];
            while (cur != null){
                int hashcode = cur.key.hashCode();
                int index = (hashcode % newArray.length + newArray.length) % newArray.length;
                Node<K,V> curN = cur.next;

                cur.next = newArray[index];
                newArray[index] = cur;

                cur = curN;
            }
        }
        array = newArray;
    }

    private double doLoadFactor(){
        return usedSize*1.0 / array.length;
    }

    public V getVal(K key){
        int hashcode = key.hashCode();
        int index = (hashcode % array.length + array.length) % array.length;
        Node<K,V> cur = array[index];
        while (cur != null){
            if (cur.key.equals(key)){
                return cur.val;
            }
            cur =cur.next;
        }
        return null;
    }
}
