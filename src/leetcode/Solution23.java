package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author WuHao
 * @create 2020-04-01-10:47
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (ListNode list : lists) {
            while(list != null){
                nums.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(nums);
        ListNode head = new ListNode(nums.get(0));
        ListNode root = head;
        for (int i = 1; i < nums.size(); i++){
            root.next = new ListNode(nums.get(i));
            root = root.next;
        }
        return head;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return merge(lists , 0 , lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int begin , int end){
        if (lists.length == 1) return lists[begin];

        int mid = (begin + end) >> 1;
        ListNode left = merge(lists, begin, mid);
        ListNode right = merge(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = null;
        if(l1.val <= l2.val){ // 使用等于保持稳定性
            head = new ListNode(l1.val);
            head.next = mergeTwoLists(l1.next , l2);
        }
        else{
            head = new ListNode(l2.val);
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }


}
