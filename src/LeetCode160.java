public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1=0,n2=0;
        ListNode cur = headA;
        while(cur!=null) {
            n1++;
            cur =cur.next;
        }
        cur = headB;
        while(cur!=null) {
            n2++;
            cur =cur.next;
        }
        if(n1<n2){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int cha = Math.abs(n1-n2);
        while(cha-->0){
            headA = headA.next;
        }
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
