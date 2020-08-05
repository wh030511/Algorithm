package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-06-05-8:39
 */
public class Solution152 {

    @Test
    public void test(){
        int max = maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(max);
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0){
                dpMax[i] = Math.max(dpMax[i-1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMin[i-1] * nums[i], nums[i]);
            }else {
                dpMax[i] = Math.max(dpMin[i-1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMax[i-1] * nums[i], nums[i]);
            }
            max = max > dpMax[i] ? max : dpMax[i];
        }
        return max;
    }


}
