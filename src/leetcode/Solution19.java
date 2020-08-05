package leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author WuHao
 * @create 2020-04-16-21:07
 */
public class Solution19 {
    // 方法一：两次遍历 使用哑节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1); // 使用哑节点处理极端情况
        dummy.next = head;
        ListNode root = head;
        int len = 0; // 记录链表长度
        while(root != null){
            len++;
            root = root.next;
        }
        int index = len - n; // index记录删除节点的前一个节点
        root = dummy; // 二次遍历
        while(index-- > 0){
            root = root.next;
        }
        root.next = root.next.next;

        return dummy.next;
    }

    // 方法二：一次遍历，双指针
    public ListNode removeNthFromEnd1(ListNode head , int n){
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow =slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}

