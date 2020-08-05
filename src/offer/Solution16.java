package offer;

import org.junit.Test;

/**
 * @Author WuHao
 * @Create 2020-08-03-19:00
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Solution16 {
    @Test
    public void test() {
        double value = myPow(2, -2);
        System.out.println(value);
    }

    /**
     * 快速幂
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
