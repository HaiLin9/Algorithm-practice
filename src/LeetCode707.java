public class LeetCode707 {

}

/**
 * µ•œÚ¡¥±Ì
 */
class MyLinkedList {
    ListNode dumHead;
    ListNode tail;
    int size;

    public MyLinkedList() {
        size =0;
        dumHead = new ListNode();
        tail = dumHead;
    }

    public int get(int index) {
        if(index<0 || index> this.size-1) {
            return -1;
        }
        ListNode cur = dumHead.next;
        while(index-->0){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val, dumHead.next);
        dumHead.next = newHead;
        if(this.size == 0){
            tail = newHead;
        }
        this.size ++;
    }

    public void addAtTail(int val) {
        if(tail == null){
            addAtHead(val);
        } else {
            ListNode newHead = new ListNode(val, null);
            tail.next = newHead;
            tail = newHead;
            this.size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if (index<0){
            addAtHead(val);
            return;
        }
        ListNode cur = this.dumHead;
        while(index-->0){
            cur = cur.next;
        }
        if(cur.next==null){
            addAtTail(val);
        } else {
            ListNode newHead = new ListNode(val, cur.next);
            cur.next = newHead;
            this.size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index <0 || index>size-1){
            return;
        }
        ListNode cur = dumHead;
        while(index-->0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        if(cur.next==null){
            tail = cur;
        }
        this.size--;
    }
}
