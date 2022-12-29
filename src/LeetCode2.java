
/**
 * @author hailin6
 * @version 2022/1/7
 */


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode();
        ListNode tail = dum;
        int carry = 0;
        while (l1!=null || l2!=null){
            int num = carry;
            if(l1 != null){
                num+=l1.val;
                l1 = l1.next;
            }
            if(l2 != null ) {
                num+= l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(num%10);
            tail = tail.next;
            carry = num/10;
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return dum.next;
    }
}
