package leetcode.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return null;
        }
        ListNode res = null;
        ListNode cur;
        int sum = 0;
        int carry = 0;
        while(l1 != null || l2 != null || sum >0) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if(sum >= 10){
                carry = 1;
                sum -= 10;
            }

            if(res == null){
                res = new ListNode(sum);
                cur = res.next;
            } else {
                cur = new ListNode(sum);
                cur = cur.next;
            }

            sum = carry;
            carry = 0;
        }
        return res;
    }
}

class ListNode{
    int val;
    public ListNode(int val){
        this.val = val;
    }
    ListNode next;
}


