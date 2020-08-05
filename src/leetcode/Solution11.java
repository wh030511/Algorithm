package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-03-10-10:13
 */


public class Solution11 {

    @Test
    public void test(){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        int[][] record = new int[grid.length][grid[0].length];
        if(grid == null || grid.length == 0) return 0;


        record[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length;i++){
            record[0][i] = record[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++) {
            record[i][0] = record[i-1][0] + grid[i][0];
        }


        for(int i = 1; i < grid.length;i++){
            for(int j = 1; j < grid[0].length;j++){
                record[i][j] = Math.min(record[i-1][j],record[i][j-1]) + grid[i][j];
            }
        }

        return record[grid.length-1][grid[0].length-1];


    }
}
