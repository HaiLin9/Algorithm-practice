public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode sorted = dum.next;
        ListNode cur= sorted.next;
        while(cur!=null) {
            if(sorted.val<=cur.val){
                sorted = cur;
                cur = cur.next;
            } else {
                ListNode pre = dum;
                while(pre.next.val<=cur.val){
                    pre = pre.next;
                }
                sorted.next = cur.next;
                cur.next = pre.next;
                pre.next= cur;
                cur = sorted.next;
            }
        }
        return dum.next;
    }
}
