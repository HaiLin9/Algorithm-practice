package leetcode;

/**
 * ����һ�����������е�Ԫ�ذ��������򣬽���ת��Ϊ�߶�ƽ��Ķ�����������
 *
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 *
 * ʾ��:
 *
 * �������������� [-10, -3, 0, 5, 9],
 *
 * һ�����ܵĴ��ǣ�[0, -3, 9, -10, null, 5], �����Ա�ʾ��������߶�ƽ�������������
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode109 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode mid = findMidList(head);
        TreeNode root = new TreeNode(mid.val);
        if(head == mid){
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    public ListNode findMidList(ListNode head){
        ListNode preSlow = null;
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null &&  fastPtr.next!=null ) {
            preSlow = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if(preSlow!=null) {
            preSlow.next = null;
        }
        return slowPtr;
    }
}
