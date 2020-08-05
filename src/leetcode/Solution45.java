package leetcode;

import org.junit.Test;

/**
 * 跳跃游戏2 LeetCode 45
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @author WuHao
 * @create 2020-03-15-9:41
 */
public class Solution45 {
    @Test
    public void test(){
        int num = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(num);
    }

    // dp
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 1;i < nums.length; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[nums.length-1];
    }

    // 贪心
    public int jump2(int[] nums){

        if(nums.length < 2){// 特判
            return 0;
        }

        int count = 0; // 记录最小跳的次数
        int curr_max_index = nums[0]; // 记录在此点能跳到的最远距离
        int pre_max_max_index = nums[0]; // 记录在点不变的条件下经过一次跳跃所能到达的最远距离
        for(int i = 0;i < nums.length ; i++){
            if(i > curr_max_index){
                count++;
                curr_max_index = pre_max_max_index;
            }
            if(nums[i] + i > pre_max_max_index){
                pre_max_max_index = nums[i] + i;
            }
        }
        return count;
    }
}
