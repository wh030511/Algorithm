package offer;

import org.junit.Test;

/**
 * @Author WuHao
 * @Create 2020-08-02-18:16
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution14 {

    @Test
    public void test() {
        int value = cuttingRope(10);
        System.out.println(value);
    }

    public int cuttingRope(int n) {
        int maxValue = 1;
        for (int i = 2; i <= n; i++) {
            int tempMax = getTempMax(n, i);
            maxValue = Math.max(maxValue,tempMax);
        }
        return maxValue % 1000000007;
    }

    // 获得该num分成broker个时所能得到的最大数
    private int getTempMax(int num, int broker) {
        int div = num / broker;
        int col = num % broker;
        int res = 1;

        for (int i = 0; i < broker - col; i++) {
            res *= div;
        }
        for (int i = broker - col; i < broker; i++) {
            res *= (div + 1);
        }
        return res;
    }
}
