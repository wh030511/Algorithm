package exam.shappe;


import com.sun.javafx.image.IntPixelGetter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 判断一个字符串是否是回文字符串
 *
 * result: ac
 */
public class Main2 {
    @Test
    public void test() {
        Integer[] arr = new Integer[]{1,3,2};
        List<Integer>  list =  Arrays.asList(arr);
        boolean res = isPalindrome(list);
        System.out.println(res);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode();
        head.next.val = 3;
        head.next.next = new ListNode();
        head.next.next.val = 2;
        boolean res = isPalindrome(head);
        System.out.println(res);
    }

    public boolean isPalindrome (ListNode pHead) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(pHead != null) {
            list.add(pHead.val);
            pHead = pHead.next;
        }
        Object[] res = list.toArray();
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (res[i] != list.get(i)) return false;
        }
        return true;
    }

    public boolean isPalindrome (List<Integer> list) {
        Integer[] res = (Integer[]) list.toArray();
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (!res[i].equals(list.get(i))) return false;
        }
        return true;
    }
}
