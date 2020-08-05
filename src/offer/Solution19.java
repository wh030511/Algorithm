package offer;

import org.junit.Test;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class Solution19 {
    @Test
    public void test() {
        boolean res = isMatch("ab", ".*");
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true; // 递归出口
        if (s.length() == 0 || p.length() == 0) return (p.length() > 1 && p.charAt(1) == '*') && isMatch(s, p.substring(2));

        //case1: 匹配
        if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
            if (p.length() > 1 && p.charAt(1) == '*'){
                return isMatch(s.substring(1), p.substring(2))
                        || isMatch(s.substring(1), p)
                        || isMatch(s, p.substring(2));
            }
            return isMatch(s.substring(1), p.substring(1));
        }

        //case2: 不匹配
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        }
        return false;

    }
}
