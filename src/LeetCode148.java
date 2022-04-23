public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode head1 = head;
        ListNode head2 =  slow.next;
        slow.next=null;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1,  ListNode head2){
        ListNode dum = new ListNode(-1);
        ListNode tail = dum;
        while(head1!=null && head2!=null) {
            if(head1.val > head2.val) {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            } else {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            }
        }
        while(head1!=null){
            tail.next = head1;
            tail = tail.next;
            head1 = head1.next;
        }
        while(head2!=null){
            tail.next = head2;
            tail = tail.next;
            head2 = head2.next;
        }
        return dum.next;
    }



}
