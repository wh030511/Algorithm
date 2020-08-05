package exam.common;

/**
 * @author WuHao
 * @create 2020-03-23-12:52
 */
public class firstmeet {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(true){
            if (p1 == null && p2 == null){
                return null;
            }
            if (p1 == null){
                p1 = headB;
            }
            if (p2 == null){
                p2 = headA;
            }
            if (p1 == p1){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }
}
