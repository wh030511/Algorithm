package offer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Solution17 {
    public int[] printNumbers(int n) {
        int ceiling = (int) Math.pow(10,n);
        int[] res = new int[ceiling];
        int value = 1;
        for (int i = 0; i < ceiling; i++) {
            res[i] = value++;
        }
        return res;
    }
}
