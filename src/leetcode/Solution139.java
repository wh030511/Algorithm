package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author WuHao
 * @create 2020-06-03-8:44
 */
public class Solution139 {

    @Test
    public void test(){
        boolean flag = wordBreak("aaaaaaa", Arrays.asList(new String[]{"aaaa", "aaa"}));
        System.out.println(flag);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int i = 0;
        int j = s.length();

        flag:
        while (j > i) {
            if (set.contains(s.substring(i, j))){
                i = j;
                j = s.length();
                continue flag;
            }
            else{
                j--;
            }
        }

        int x = 0;
        int y = 1;

        while (y <= s.length()) {
            if (set.contains(s.substring(x, y))){
                x = y;
            }

            y++;
        }

        return i == s.length() || x == s.length();
    }
}
