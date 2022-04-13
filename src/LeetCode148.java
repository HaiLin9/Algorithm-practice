public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode cur = head;
        while(cur.next!=null){
            cur= cur.next;
        }
        return sortList(head, cur);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=tail) {
            fast = fast.next;
            if(fast!=tail) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode head1 = sortList(head, slow);
        ListNode head2 = sortList(next, tail);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dum = new ListNode();
        ListNode tail = dum;
        while(head1!=null && head2!=null){
            if(head1.val>head2.val){
                tail.next = head2;
                tail= head2;
                head2= head2.next;
            } else {
                tail.next = head1;
                tail= head1;
                head1= head1.next;
            }
        }
        while(head1!=null){
            tail.next = head1;
            tail= head1;
            head1= head1.next;
        }
        while(head2!=null){
            tail.next = head2;
            tail= head2;
            head2= head2.next;
        }
        return dum.next;
    }
}
