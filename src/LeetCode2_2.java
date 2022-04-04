/**
 * @author hailin6
 * @version 2022/1/11
 */



public class LeetCode2_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=null, tail =null;
        while(l1 != null || l2 != null) {
            int num = carry;
            if(l1!=null) {
                num += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                num += l2.val;
                l2= l2.next;
            }
            if(num>=10){
                carry =1;
            } else {
                carry = 0;
            }
            if(head == null) {
                head = new ListNode(num%10);
                tail = head;
            } else {
                ListNode newNode = new ListNode(num%10);
                tail.next = newNode;
                tail = newNode;
            }
        }
        if(carry==1){
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return head;
    }
}
