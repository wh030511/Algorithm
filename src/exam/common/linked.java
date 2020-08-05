package exam.common;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-03-22-6:45
 */
public class linked {
    @Test
    public void test(){
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i : arr) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        ListNode ln = reverseList(head);
        while(ln != null){
            System.out.println(ln.val);
            ln = ln.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
