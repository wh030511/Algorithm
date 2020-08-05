package leetcode;

import org.junit.Test;

/**
 * 跳跃游戏1
 * @author WuHao
 * @create 2020-03-15-8:45
 */
public class Solution55 {
    @Test
    public void test(){
        boolean res = jump(new int[]{2,0});
        System.out.println(res);
    }


    // dp
    public boolean canJump(int[] nums) {
        if(nums == null) return false;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length ; i++){
            if(dp[i]){

                for(int j = i+1 ; j <= i+nums[i] && j < nums.length; j++){
                    dp[j] = true;
                    if(dp[nums.length - 1]){
                        return true;
                    }
                }
            }
        }
        return dp[nums.length-1];
    }

    // 贪心
    public boolean jump(int[] nums){
        int[] max_index = new int[nums.length]; // 记录从此点最远能到达的位置
        for(int i = 0; i < nums.length; i++){
            max_index[i] = i + nums[i];
        }
        int max_pointer = nums[0];
        for(int i = 0; i < nums.length;i++){
            if (max_pointer >= nums.length-1) return true;
            if(i > max_pointer) return false;
            max_pointer = Math.max(max_pointer, max_index[i]);

        }
        return false;
    }
}
