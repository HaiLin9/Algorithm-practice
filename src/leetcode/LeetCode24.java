package leetcode;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ?
 *
 * ʾ��:
 *
 * ���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode24 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        } else if(head.next ==null){
            return head;
        } else {
            ListNode newHead = head.next.next;
            newHead = swapPairs(newHead);
            head.next.next = head;
            ListNode result = head.next;
            head.next = newHead;
            return result;
        }
    }
}
