package leetcode;

import org.junit.Test;

/**
 * 最长公共子串
 * @author WuHao
 * @create 2020-04-21-17:50
 */
public class Solution1143 {

    @Test
    public void test(){
        System.out.println(longestCommonSubsequence("abcdae", "ace"));
    }

    public String longestCommonSubsequence(String text1 , String text2){
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    sb.append(text1.charAt(i-1));
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return sb.toString();
    }
}
