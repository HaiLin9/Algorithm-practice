
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
        ListNode result = null;
        ListNode tail = null;
        long n1 =0, n2=0;
        long base = 1;
        while(l1!=null){
            n1+= l1.val * base;
            l1= l1.next;
            base*=10;
        }
        base = 1;
        while(l2!=null){
            n2+= (l2.val * base);
            l2= l2.next;
            base*=10;
        }

        n1 +=n2;
        if(n1==0){
            return new ListNode(0);
        }
        while(n1!=0){
            long val = n1%10;
            n1/=10;
            ListNode tmp = new ListNode((int)val, null);
            if(result == null) {
                result =tmp;
            }
            if(tail==null){
                tail = tmp;
            } else{
                tail.next = tmp;
                tail = tail.next;
            }
        }
        return result;
    }
}
