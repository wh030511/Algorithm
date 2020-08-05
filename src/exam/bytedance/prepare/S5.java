package exam.bytedance.prepare;

/**
 * @author WuHao
 * @create 2020-04-28-15:39
 */
public class S5 {
    public String longestPalindrome(String s) { // 动态规划
        if (s == null || s.length() < 2) return s;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int maxLen = 1; // 最长回文长度
        for (int right = 1; right < len; right++){
            for (int left = 0; left < right; left++){
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left+1][right-1])){
                    dp[left][right] = true;
                    if (right - left + 1 > maxLen){
                        start = left;
                        end = right;
                        maxLen = right - left + 1;
                    }
                }

            }
        }
        return s.substring(start, end+1);
    }
}
