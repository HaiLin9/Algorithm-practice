/**
 * @author hailin6
 * @version 2022/1/13
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(n-->0){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
