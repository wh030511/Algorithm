package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WuHao
 * @create 2020-03-31-10:55
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<String> set = new HashSet<>();
        while(head != null){
            if (set.contains(head.toString())) return head;
            set.add(head.toString());
            head = head.next;
        }
        return null;
    }
}
