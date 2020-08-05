package exam.common;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-08-01-17:14
 * 减绳子
 */
public class cut_cord {

    @Test
    public void test1() {

    }

    public int cutRope(int target) {
        if (target <= 2) return 1; // border case
        int res = 0;
        for (int i = 2; i < target; i++) {
            int tempMax = getMax(target, i);
            res = Math.max(tempMax, res);
        }
        return res;
    }

    // num ： 长度 chuck ： 块数
    private int getMax(int num, int chuck) {
        int div = num / chuck; // 商
        int mod = num % chuck; // 余数
        int tempMax = 1;

        for (int i = 0; i < chuck - mod; i++) {
            tempMax *= div;
        }
        for (int i = chuck - mod; i < chuck; i++) {
            tempMax *= (div + 1);
        }
        return tempMax;
    }
}


