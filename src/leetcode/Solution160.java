package leetcode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author WuHao
 * @create 2020-03-31-9:58
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA.next;
            pB = pB.next;

            if (pA == null){
                pA = headB;
            }
            if (pB == null){
                pB = headA;
            }

            if (pA == null && pB == null) return null;
        }
        return pA;
    }
}
