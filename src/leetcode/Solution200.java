package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-06-11-9:17
 */
public class Solution200 {

    @Test
    public void test(){
        char[][] param = {{'1','0','1','1','0','1','1'}};
        int count = numIslands(param);
        System.out.println(count);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0] == '1' ? 1 : 0;
        int m = 1;
        while (m < grid[0].length){
            dp[0][m] = grid[0][m] == '1'&&grid[0][m-1] == '0' ? dp[0][m-1]+1:dp[0][m-1];
            m++;
        }
        int k = 1;
        while (k < grid.length) {
            dp[k][0] = grid[k][0] == '1'&&grid[k-1][0] == '0' ? dp[k-1][0]+1:dp[k-1][0];
            k++;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++){
                if (grid[i][j] == '1' && grid[i][j-1] == '0' && grid[i-1][j] == '0'){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
