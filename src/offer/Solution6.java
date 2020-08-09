package offer;

import java.util.ArrayList;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:51
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 */
public class Solution6 {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ln = head; // 当前节点
        while(ln.next != null){
            list.add(ln.val);
            ln = ln.next;

        }
        list.add(ln.val);

        int[] result = new int[list.size()]; //数组长度
        int index = list.size() - 1;
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(index--);
        }
        return result;
    }
}
