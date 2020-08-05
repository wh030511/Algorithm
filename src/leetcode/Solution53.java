package leetcode;

/**
 * @author WuHao
 * @create 2020-05-21-9:20
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for(int i = 1 ; i < nums.length ; i++){
            dp[i] = Math.max(dp[i-1] + nums[i] , nums[i]);
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }
}
