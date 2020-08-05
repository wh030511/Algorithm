package leetcode;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * @author WuHao
 * @create 2020-04-26-9:33
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        int column = 0; // 第一列
        int row = n-1; // 最后一行
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = matrix[row--][column];
            }
            row = n - 1;
            column++;
        }
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }

}
