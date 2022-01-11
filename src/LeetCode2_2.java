/**
 * @author hailin6
 * @version 2022/1/11
 */



public class LeetCode2_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = null;
        ListNode tail = null;
        while(l1!=null && l2!= null){
            int num = l1.val+l2.val+carry;
            if(num>=10){
                carry =1;
            } else {
                carry =0;
            }
            if(tail==null){
                res= new ListNode(num%10);
                tail = res;
            } else {
                tail.next = new ListNode(num%10);
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null) {
            int num = l1.val+carry;
            if(num>=10){
                carry =1;
            } else {
                carry =0;
            }
            if(tail==null){
                res= new ListNode(num%10);
                tail = res;
            } else {
                tail.next = new ListNode(num%10);
                tail = tail.next;
            }
            l1 = l1.next;
        }
        while(l2!=null) {
            int num = l2.val+carry;
            if(num>=10){
                carry =1;
            } else {
                carry =0;
            }
            if(tail==null){
                res= new ListNode(num%10);
                tail = res;
            } else {
                tail.next = new ListNode(num%10);
                tail = tail.next;
            }
            l2 = l2.next;
        }
        if(carry == 1){
            if(tail==null){
                res= new ListNode(carry);
                tail = res;
            } else {
                tail.next = new ListNode(carry);
                tail = tail.next;
            }
            carry =0;
        }
        return res;

    }
}
