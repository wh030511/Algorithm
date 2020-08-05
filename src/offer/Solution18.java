package offer;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import com.sun.security.sasl.ClientFactoryImpl;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            }
            pre = pre.next;
            curr = curr.next;
        }
        return head;
    }
}
