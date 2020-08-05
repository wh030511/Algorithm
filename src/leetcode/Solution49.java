package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author WuHao
 * @create 2020-05-19-8:37
 */
public class Solution49 {
    @Test
    public void test(){
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        String[] newStrs = resort(strs);
        Map<String , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < newStrs.length; i++){
            List<Integer> integers = map.get(newStrs[i]);
            if (integers == null){
                integers = new ArrayList<>();
            }
            integers.add(i);
            map.put(newStrs[i], integers);
        }
        List<List<String>> res = new ArrayList<>();
        for (String str : map.keySet()) {
            List<String> item = new ArrayList<>();
            List<Integer> integers = map.get(str);
            for (Integer integer : integers) {
                item.add(strs[integer]);
            }
            res.add(item);
        }
        return res;
    }
    private String[] resort(String[] args){ // 将数组中每个元素按字母序重新排列
        String[] res = new String[args.length];
        for(int i = 0; i < args.length; i++){
            String tmp = new String(args[i]); // 不改变原数组
            char[] chars = tmp.toCharArray();
            Arrays.sort(chars);
            res[i] = String.valueOf(chars);
        }
        return res;
    }
}
