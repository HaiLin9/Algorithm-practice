package leetcode;

/**
 * ����һ������ÿ?k?���ڵ�һ����з�ת�����㷵�ط�ת�������
 *
 * k?��һ��������������ֵС�ڻ��������ĳ��ȡ�
 *
 * ����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 *
 * ʾ�� :
 *
 * �����������1->2->3->4->5
 *
 * ��?k?= 2 ʱ��Ӧ������: 2->1->4->3->5
 *
 * ��?k?= 3 ʱ��Ӧ������: 3->2->1->4->5
 *
 * ˵�� :
 *
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode25 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head;
        for(int i=1;i<=k ;i++) {
            if(fast==null){
                return head;
            }
            fast = fast.next;
        }
        //��ǰ���ȴ��ڵ���k
        ListNode pre = null;
        ListNode cur = head;
        for(int i =1;i<=k;i++) {
            ListNode next = cur.next;
            cur.next  = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur,k);
        return pre;
    }
}
