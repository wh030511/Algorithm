package offer;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Solution21 {
    @Test
    public void test() {
        int[] res = exchange(new int[]{3, 1, 2, 4, 5, 6, 7, 10});
        for (int i : res) {
            System.out.println(i);
        }
    }
    public int[] exchange(int[] nums) {
        // 双指针
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) left++; // 找到第一个偶数
            while (left < right && nums[right] % 2 == 0) right--; // 找到第一个奇数
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
