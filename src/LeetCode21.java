/**
 * @author hailin6
 * @version 2022/1/13
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3=new ListNode();
        ListNode l3Tail=l3;
        while(list1 != null && list2!=null){
            if(list1.val<list2.val){
                l3Tail.next = list1;
                l3Tail = l3Tail.next;
                list1 = list1.next;
            } else {
                 l3Tail.next = list2;
                 l3Tail = l3Tail.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            l3Tail.next = list1;
        }
        if(list2 != null ){
            l3Tail.next = list2;
        }
        return l3.next;


    }
}
