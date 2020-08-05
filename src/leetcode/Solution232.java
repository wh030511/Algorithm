package leetcode;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * @author WuHao
 * @create 2020-03-27-10:12
 */
public class Solution232 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public Solution232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.empty()){
            return stack2.pop();
        }
        while(!stack1.empty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.empty()){
            return stack2.peek();
        }
        while (!stack1.empty()){
            stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
