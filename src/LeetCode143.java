import java.util.ArrayList;
import java.util.List;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        ListNode cur =head;
        while(cur!=null){
            arr.add(cur);
            cur = cur.next;
        }
        ListNode dum = new ListNode();
        ListNode tail = dum;
        int i=0,j=arr.size()-1;
        while(i<j){
            tail.next = arr.get(i);
            tail = tail.next;
            tail.next = arr.get(j);
            tail = tail.next;
            i++;
            j--;
            if(i==j){
                tail.next = arr.get(i);
                tail = tail.next;
            }
        }
        tail.next = null;
    }
}
