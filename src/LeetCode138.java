import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map= new HashMap<>();
        Node cur = head;
        while(cur!=null){
            if(!map.containsKey(cur)){
                map.put(cur, new Node(cur.val));
            }
            Node newCur = map.get(cur);
            if(cur.next != null && !map.containsKey(cur.next)){
                map.put(cur.next, new Node(cur.next.val));
            }
            newCur.next = map.getOrDefault(cur.next, null);
            if(cur.random != null && !map.containsKey(cur.random)){
                map.put(cur.random, new Node(cur.random.val));
            }
            newCur.random = map.getOrDefault(cur.random, null);
            cur = cur.next;
        }
        return map.get(head);
    }

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
}


