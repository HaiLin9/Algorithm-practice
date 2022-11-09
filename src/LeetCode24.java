/**
 * @author hailin6
 * @version 2022/1/17
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dumNode = new ListNode();
        dumNode.next = head;
        ListNode cur = dumNode;
        while(cur.next!=null && cur.next.next!=null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = first;
        }
        return dumNode.next;
    }
}
