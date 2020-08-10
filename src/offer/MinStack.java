package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-10-14:54
 *
 * 剑指offer30题
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)
 */
class MinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(12);
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }

    private List<Integer> value;
    private List<Integer> minValue;
    private int curr; // 指针
    private int recordMin;
    /** initialize your data structure here. */
    public MinStack() {
        value = new ArrayList<>();
        minValue = new ArrayList<>();
        recordMin = Integer.MAX_VALUE;
        curr = -1;
    }

    public void push(int x) {
        value.add(x);
        recordMin = Math.min(recordMin, x);
        minValue.add(recordMin);
        curr++;
    }

    public void pop() {
        if (curr < 0) return; // 不合法

        value.remove(curr);
        minValue.remove(curr);
        curr--;
        recordMin = curr < 0 ? Integer.MAX_VALUE : minValue.get(curr);
    }

    public int top() {
        return curr >= 0 ? value.get(curr) : -1;
    }

    public int min() {
        return curr >= 0 ? minValue.get(curr) : -1;
    }
}
