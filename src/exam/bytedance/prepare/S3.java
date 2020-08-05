package exam.bytedance.prepare;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuHao
 * @create 2020-04-28-14:57
 */
public class S3 {
    @Test
    public void test(){
        int num = lengthOfLongestSubstring("abba");
        System.out.println(num);
    }

    public int lengthOfLongestSubstring(String s) {
       Map<Character , Integer> map  = new HashMap<>();
       int lenght = 0;
       for (int i = 0, j = 0; j < s.length(); j++){
           if (map.containsKey(s.charAt(j))){
               i = Math.max(i , map.get(s.charAt(j)));
           }
           lenght = Math.max(lenght, j - i + 1);
           map.put(s.charAt(j), j+1);
       }
       return lenght;
    }

}
