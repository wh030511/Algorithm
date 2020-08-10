package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WuHao
 * @Create 2020-08-10-14:09
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class Solution29 {
    @Test
    public void test() {
        int[] res = spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        for (int num : res) System.out.print(num + " ");
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};

        ArrayList<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        recur(list, matrix, 0, matrix.length-1, 0, matrix[0].length-1);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void recur(List<Integer> list, int[][] matrix, int startX, int endX, int startY, int endY) {
        if (startX > endX || startY > endY) return;

        // 特判:如果只有一行
        if (startX == endX) {
            for (int i = startY; i <= endY; i++) list.add(matrix[startX][i]);
            return;
        }
        // 特判：如果只有一列
        if (startY == endY) {
            for (int i = startX; i <= endX; i++) list.add(matrix[i][startY]);
            return;
        }

        for (int i = startY; i <= endY; i++) list.add(matrix[startX][i]);
        for (int i = startX+1; i <= endX; i++) list.add(matrix[i][endY]);
        for (int i = endY-1; i >= startY; i--) list.add(matrix[endX][i]);
        for (int i = endX-1; i > startX; i--) list.add(matrix[i][startY]);

        recur(list, matrix, startX+1, endX-1, startY+1, endY-1);
    }
}
