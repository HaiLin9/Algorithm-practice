import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    DListNode head;
    DListNode tail;
    Map<Integer, DListNode> m;

    public LRUCache(int capacity) {
        this.capacity= capacity;
        m = new HashMap<>();
        head = new DListNode(-1,-1);
        tail = new DListNode(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(m.containsKey(key)){
            DListNode node = m.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            node.next.pre =node;
            head.next = node;
            node.pre = head;
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(m.containsKey(key)){
            DListNode node = m.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            node.next.pre =node;
            head.next = node;
            node.pre = head;
        } else {
            if(m.size() == this.capacity) {
                DListNode node = tail.pre;
                node.pre.next= tail;
                tail.pre = node.pre;
                m.remove(node.key);
            }
            DListNode node = new DListNode(key, value);
            node.next = head.next;
            node.next.pre =node;
            head.next = node;
            node.pre = head;
            m.put(key, node);
        }
    }

    class DListNode {
        DListNode pre;
        DListNode next;
        int key;
        int val;
        DListNode(int key ,int value) {
            this.key = key;
            this.val = value;
        }
    }
}






