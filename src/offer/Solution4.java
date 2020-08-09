package offer;

import java.util.Arrays;

/**
 * @Author WuHao
 * @Create 2020-08-09-23:50
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int n = matrix.length; // 行数n
        int m = matrix[0].length; // 列数m
        int[] ints = new int[n * m] ;
        for(int i = 0; i < n; i ++){
            for(int j = 0;j < m; j++){
                ints[i*m + j] = matrix[i][j];
            }
        }
        Arrays.sort(ints);
        int index = Arrays.binarySearch(ints,target);
        return index >=0 ;
    }
}
