package leetcode;

/**
 * @author WuHao
 * @create 2020-04-17-18:27
 */
class Solution21{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = null;
        if(l1.val <= l2.val){
            head = new ListNode(l1.val);
            head.next = mergeTwoLists(l1.next , l2);
        }
        else{
            head = new ListNode(l2.val);
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }
}
