package leetcode;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * @author WuHao
 * @create 2020-03-31-10:40
 */
public class Solution144 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if (fast == null) return false;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;

            slow = slow.next;

            if (fast == slow) return true;
        }
    }
}
