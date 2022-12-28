public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null){
            return head;
        }
        boolean isKLen = true;
        ListNode cur =head;
        for(int i=1;i<k;i++ ){
            cur = cur.next;
            if(cur==null){
                isKLen = false;
                break;
            }
        }
        if(!isKLen){
            return head;
        }
        ListNode nextHead = reverseKGroup(cur.next, k);
        cur.next = null;
        ListNode newHead=reverseList(head);
        head.next = nextHead;
        return newHead;
    }

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
