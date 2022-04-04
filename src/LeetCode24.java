/**
 * @author hailin6
 * @version 2022/1/17
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode pre = null;
        head = second;
        while (first != null && second != null) {
            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;
            if(pre != null){
                pre.next = second;
            }
            if(tmp!=null){
                pre = first;
                first = tmp;
                second = tmp.next;
            } else {
                break;
            }
        }
        return head;

    }
}
