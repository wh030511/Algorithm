package leetcode;

import org.junit.Test;

/**
 * 分割等和子集
 * @author WuHao
 * @create 2020-03-15-22:10
 */
public class Solution416 {
    @Test
    public void test(){

    }

    private boolean canPartition(int[] nums){
        if (nums == null || nums.length < 2) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false; // 特判

        int target = sum / 2; // 要达到的数
        boolean[][] dp = new boolean[nums.length][target+1];
        for (int i = 0; i < dp.length; i++){
            if(nums[0] == i) dp[0][i] = true;
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else if(nums[i] == j){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[nums.length-1][target];
    }
}
