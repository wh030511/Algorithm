package leetcode;

import org.junit.Test;

import java.util.Stack;

/**给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * @author WuHao
 * @create 2020-03-29-13:25
 */
public class Solution946 {
    @Test
    public void test(){
        System.out.println(validateStackSequences(new int[]{1,0,2}, new int[]{2,1,0}));

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : pushed){
            stack.push(i);
            // 如果相同则弹出
            while (!stack.empty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
