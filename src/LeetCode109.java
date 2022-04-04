import java.util.HashMap;
import java.util.Map;

public class LeetCode109 {
    public TreeNode sortedListToBST(ListNode head) {
        return help(head, null);
    }

    public TreeNode help(ListNode left, ListNode right) {
        if(left == right){
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = help(left, mid);
        root.right = help(mid.next,right);
        Map<String, String> m = new HashMap<>();
        m.put("1","1");
        return  root;
    }

    public ListNode getMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
