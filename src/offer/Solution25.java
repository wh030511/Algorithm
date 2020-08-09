package offer;

/**
 * @Author WuHao
 * @Create 2020-08-09-18:59
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        helper(pre, l1, l2);
        return pre.next;
    }

    private void helper(ListNode curr, ListNode l1, ListNode l2) {
        if (l1 == null) {
            curr.next = l2;
            return;
        }
        if (l2 == null) {
            curr.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            curr.next = new ListNode(l1.val);
            helper(curr.next, l1.next, l2);
        } else {
            curr.next = new ListNode(l2.val);
            helper(curr.next, l1, l2.next);
        }
    }
}
