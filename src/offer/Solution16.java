package offer;

/**
 * @Author WuHao
 * @Create 2020-08-03-19:00
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Solution16 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        return x * myPow(x, n-1);
    }
}
