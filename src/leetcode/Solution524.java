package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * @author WuHao
 * @create 2020-03-17-7:51
 */
public class Solution524 {
    @Test
    public void test(){
        String s = "abpcplea";
        ArrayList<String> d = new ArrayList<String>(){
            {
                add("ale");
                add("apple");
                add("monkey");
                add("plea");
            }
        };
        String res = findLongestWord(s, d);
        System.out.println(res);
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length() != 0?
                                    o2.length()-o1.length(): o1.compareTo(o2);
            }
        });

        for (String s1 : d) {
            if (contains(s, s1)) return s1;
        }

        return "";
    }

    // 判断str1中是否包含str2
    private boolean contains(String str1,String str2){
        int i = 0;
        int j = 0;
        while(i < str1.length() && j < str2.length()){
            if (j == str2.length()-1 && str1.charAt(i) == str2.charAt(j)){
                return true;
            }
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
