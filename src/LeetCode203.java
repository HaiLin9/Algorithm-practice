public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum;
        ListNode cur = head;
        while(cur!=null) {
            if(cur.val==val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dum.next;
    }
}
