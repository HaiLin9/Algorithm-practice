package leetcode.linkedlist;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        RemoveNthFromEnd.ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public RemoveNthFromEnd.ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        RemoveNthFromEnd.ListNode firstNode = null;
        RemoveNthFromEnd.ListNode secondNode = head;
        for(int i=1;i<=n;i++) {
           if(secondNode.next != null){
               secondNode = secondNode.next;
               if(i==n){
                   firstNode = head;
               }
           }
        }
        while(secondNode.next != null) {
            firstNode = firstNode.next;

            secondNode = secondNode.next;
        }

        if(firstNode==null){
            head = head.next;
        } else{
            firstNode.next = firstNode.next.next;
        }
        return head;
    }
}


