package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author WuHao
 * @Create 2020-08-10-15:13
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class Solution31 {
    @Test
    public void test() {
        boolean res = validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0});
        System.out.println(res);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        flag:
        for (int value : popped) {
            while (index < pushed.length) {
                if (pushed[index] == value){
                    index++;
                    continue flag;
                }
                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.poll();
                    continue flag;
                }
                stack.push(pushed[index++]);
            }
            if (!stack.isEmpty() && stack.peek() == value) {
                stack.poll();
                continue flag;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
