import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-18
 * Time: 22:52
 */
public class Ti {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashmap = new HashMap<>();
        Node cur = head; //旧节点
        while(cur != null){
            Node newNode = new Node(cur.val); //新节点
            hashmap.put(cur,newNode); // 旧节点和新节点的映射
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            hashmap.get(cur).next = hashmap.get(cur.next);
            hashmap.get(cur).random = hashmap.get(cur.random);
            cur = cur.next;
        }
        return hashmap.get(head);
    }

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hashSet =new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            hashSet.add(jewels.charAt(i));
        }
        int size = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (hashSet.contains(stones.charAt(i))){
                size++;
            }
        }
        return size;
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        //1. 统计每个单词出现的次数
        for (String word : words) {
            if (hashMap.get(word) == null){
                hashMap.put(word,1);
            }else {
                int val = hashMap.get(word);
                hashMap.put(word,val+1);
            }
        }
        //2.建立小根堆
        PriorityQueue<Map.Entry<String,Integer>> priorityQueue =new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        //3.遍历hashMap
        for (Map.Entry<String,Integer> entry: hashMap.entrySet()){
            if (priorityQueue.size() < k){
                priorityQueue.add(entry);
            }else {
                Map.Entry<String ,Integer> top = priorityQueue.peek(); //弹出根元素
                if (entry.getValue().compareTo(top.getValue()) > 0){
                    priorityQueue.poll();
                    priorityQueue.add(top);
                }else if (entry.getValue().compareTo(top.getValue()) == 0){
                    if (entry.getKey().compareTo(top.getKey()) < 0){
                        priorityQueue.poll();
                        priorityQueue.add(top);
                    }
                }
            }
        }
        ArrayList<String> list =new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> entry = priorityQueue.poll();
            list.add(entry.getKey());
        }
        Collections.reverse(list);
        return list;
    }
}
