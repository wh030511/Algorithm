package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-03-16-7:04
 */
public class Solution279 {
    @Test
    public void test(){
        System.out.println(numSquares(12));
    }

    public int numSquares(int n) {
        int m = (int)Math.sqrt(n);
        int[][] dp = new int[m][n+1];
        for (int i = 0; i < dp.length; i++){dp[i][0] = 0;}
        for (int i = 1; i < dp[0].length; i++){dp[0][i] = i;}

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int num = (i+1)*(i+1);
                if (j == num){
                    dp[i][j] = 1;
                }else if (j < num){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int mod = j % num;
                     if (dp[i-1][mod] >= 0){

                     }
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-num] + 1);
                }
            }
        }

        return dp[m-1][n];
    }
}
