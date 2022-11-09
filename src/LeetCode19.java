/**
 * @author hailin6
 * @version 2022/1/13
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumNode = new ListNode();
        dumNode.next = head;
        ListNode fast = dumNode;
        ListNode slow = dumNode;
        while(n-->0) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast= fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dumNode.next;
    }
}
