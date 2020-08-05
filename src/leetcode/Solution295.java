package leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**设计一个支持以下两种操作的数据结构：

 void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 double findMedian() - 返回目前所有元素的中位数。
 * @author WuHao
 * @create 2020-03-30-9:25
 */
public class Solution295 {
    @Test
    public void test(){
        Solution295 s = new Solution295();
        for (int i = 1; i < 5; i++){
            s.addNum(i);
        }
        System.out.println(s.findMedian());
    }

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public Solution295() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }); // 最大堆
        minHeap = new PriorityQueue<>(); // 最小堆

    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.peek());
        maxHeap.poll();

        if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }
    }

    public double findMedian() {

        return minHeap.size() < maxHeap.size() ? (double)maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}
