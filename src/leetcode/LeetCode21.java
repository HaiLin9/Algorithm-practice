package leetcode;

/**
 * ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�?
 *
 * ʾ����
 *
 * ���룺1->2->4, 1->3->4
 * �����1->1->2->3->4->4
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-two-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumHead = new ListNode(0);
        ListNode cur = dumHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while(l1!=null){
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2!=null){
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return dumHead.next;
    }

}
