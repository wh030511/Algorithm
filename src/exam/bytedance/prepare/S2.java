package exam.bytedance.prepare;

/**
 * @author WuHao
 * @create 2020-04-27-21:47
 */
public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0;
        long num2 = 0;
        int k = 0;
        while(l1 != null){
            num1 += l1.val * Math.pow(10, k++);
            l1 = l1.next;
        }
        k = 0;
        while(l2 != null){
            num2 += l2.val * Math.pow(10, k++);
            l2 = l2.next;
        }
        String res = Long.toString(num1 + num2);
        ListNode root = new ListNode(-1);
        ListNode tmp = root;
        for (int i = 0; i < res.length(); i++){
            int num = res.charAt(i) - '0';
            tmp.next = new ListNode(num);
            tmp = tmp.next;
        }
        return root;
    }

    private ListNode transfer(ListNode root){ // 链表逆序
        ListNode prev = null;
        ListNode curr = root;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
