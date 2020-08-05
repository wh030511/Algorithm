package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-05-25-8:50
 */
public class Solution96 {

    @Test
    public void test(){
        System.out.println(numTrees(5));
    }

    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
