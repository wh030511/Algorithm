package leetcode;

import java.util.Arrays;

/**
 * @author WuHao
 * @create 2020-05-29-8:51
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] != nums[i+1]) return nums[i];
            while (nums[i] == nums[i+1] && i < nums.length - 1) i++;
        }
        return nums[nums.length-1];
    }

    public int singleNumber2(int[] nums) {
       int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
