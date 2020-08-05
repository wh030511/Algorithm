package exam.bytedance.prepare;

/**
 * @author WuHao
 * @create 2020-04-29-22:12
 */
public class S19 {
    public ListNode removeNthFromEnd(ListNode head , int n){ // 快慢指针
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return pre.next;
    }
}
