public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur = head;
        while(cur!=null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
