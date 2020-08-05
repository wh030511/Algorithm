package leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @author WuHao
 * @create 2020-03-30-8:47
 */
public class Solution215 {
    @Test
    public void test(){
        System.out.println(findKthLargest(new int[]{1,2,3}, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) minHeap.offer(num);
            else if (minHeap.peek() < num){
                minHeap.poll();
                minHeap.offer(num);
            }
            else continue;
        }
        return minHeap.peek();
    }
}
