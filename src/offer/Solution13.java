package offer;

import org.junit.Test;

/**
 * @author WuHao
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 */
public class Solution13 {

    @Test
    public void test() {
        int count = movingCount(1, 2, 1);
        System.out.println(count);
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n]; // default: false
        return getCount(0, 0, m, n, k, visited);
    }

    private int getCount(int row, int col, int m, int n, int target, boolean[][] visited) {
        if (row < 0 || row >= m) return 0;
        if (col < 0 || col >= n) return 0;
        if (visited[row][col]) return 0; // had visited
        if (!illegal(target, row, col)) return 0;

        visited[row][col] = true;
        return 1 + getCount(row+1, col, m, n, target, visited)
                + getCount(row-1, col, m, n, target, visited)
                + getCount(row,col + 1, m, n, target, visited)
                + getCount(row,col - 1, m, n, target, visited);
    }

    private boolean illegal(int target, int row, int col) {
        int sum = row / 10 + row % 10 + col / 10 + col % 10;
        return sum <= target;
    }
}
