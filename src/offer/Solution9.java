package offer;

import java.util.Stack;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:52
 *
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Solution9 {
    class CQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else if(stack2.isEmpty() && !stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }else{
                return -1;
            }
        }
    }
}


