package offer;

import org.junit.Test;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 */
public class Solution20 {
    @Test
    public void test() {
        boolean res = isNumber("3.1415");
        System.out.println(res);
    }
    public boolean isNumber(String s) {
        return false;
    }
}
