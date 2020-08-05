package leetcode;

import org.junit.Test;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @author WuHao
 * @create 2020-03-31-9:08
 */
public class Solution95 {
    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode root = head;
        for (int i = 2; i <= 5; i++){
            root.next = new ListNode(i);
            root = root.next;
        }
        ListNode listNode = reverseBetween(head, 2, 4);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null) return null;
        ListNode curr = head;
        ListNode pre = null;

        for (int i = 1; i < m; i++){ // 经过循环 curr指向m pre指向m之前的元素
            pre = curr;
            curr = curr.next;
        }

        ListNode ppre = null; // 开始反转链表，记录前一个元素
        ListNode mNode = curr; // 记录m所在位置的元素
        for (int i = m; i < n; i++){
            ListNode tmp = curr.next;
            curr.next = ppre;
            ppre = curr;
            curr = tmp;
        }
        ListNode next = curr.next;
        curr.next = ppre;
        pre.next = curr;
        mNode.next = next;


        return head;
    }
}
