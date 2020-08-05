package leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 *
 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。
 * @author WuHao
 * @create 2020-03-31-11:41
 */
public class Solution86 {

    @Test
    public void test(){
        ListNode head = new ListNode(3);
        ListNode root = head;
        root.next = new ListNode(1);
//        root = root.next;
//        root.next = new ListNode(3);
//        root = root.next;
//        root.next = new ListNode(2);
//        root = root.next;
//        root.next = new ListNode(5);
        root = root.next;
        root.next = new ListNode(2);
        ListNode partition = partition(head, 3);
        while(partition != null){
            System.out.println(partition.val);
            partition = partition.next;
        }

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode root = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(root != null){
            list.add(root.val);
            root = root.next;
        }
        int flag = 0;
        boolean isChanged = false;
        for (int index = 0; index < list.size(); index++){
            if (x <= list.get(index)){
                flag = index;
                isChanged = true;
                break;
            }
        }
        for (int i = flag + 1; isChanged && i < list.size(); i++){
            if (list.get(i) < x){
                list.add(flag,list.get(i));
                flag++;
                list.remove(i+1);
            }
        }

        root = head;
        int index = 0;
        while(root != null){
            root.val = list.get(index++);
            root = root.next;
        }

        return head;

    }

    public ListNode partition1(ListNode head, int x){
        ListNode lessHead = new ListNode(-1); // 小于x的临时头节点
        ListNode moreHead = new ListNode(-1); // 大于等于x的临时头节点

        ListNode lessPtr = lessHead;
        ListNode morePtr = moreHead;

        while(head != null){ // 遍历原链表
            if (head.val < x){
                lessPtr.next = new ListNode(head.val);
                lessPtr = lessPtr.next;
            }else{
                morePtr.next = new ListNode(head.val);
                morePtr = morePtr.next;
            }
            head = head.next;
        }
        lessPtr.next = moreHead.next;
        lessHead = lessHead.next;

        return lessHead;
    }
}
