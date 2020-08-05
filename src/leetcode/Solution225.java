package leetcode;

import java.util.LinkedList;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * @author WuHao
 * @create 2020-03-27-10:19
 */
public class Solution225 {
    LinkedList<Integer> queue1 = new LinkedList<>(); // LinkedList实现了Queue接口
    LinkedList<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public Solution225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.pop();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size() == 0;
    }
}
