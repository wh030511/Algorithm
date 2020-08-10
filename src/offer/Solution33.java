package offer;

import org.junit.Test;

/**
 * @Author WuHao
 * @Create 2020-08-10 18:39
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length-1);
    }

    private boolean recur(int[] nums, int start, int end) {
        if (end <= start) return true;

        int curr = start;
        while (nums[curr] < nums[end]) curr++;
        int index = curr;
        while(nums[curr] > nums[end]) curr++;
        return end == curr && recur(nums, start, index-1) && recur(nums, index, end-1);
    }
}
