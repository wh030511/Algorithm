package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列
 * @author WuHao
 * @create 2020-03-18-7:31
 */
public class Solution451 {
    @Test
    public void test(){
        System.out.println(frequencySort("aaaccc"));
    }

    public String frequencySort(String s) {
        if(s == null) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length();i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Integer> list = new ArrayList<>(entries.size());
        for (Map.Entry<Character, Integer> entry : entries) {
            list.add(entry.getValue());
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        Set<Character> set = new HashSet<>();

        flag:
        for (Integer integer : list) {
            for (Map.Entry<Character, Integer> entry : entries) {
                if (entry.getValue() == integer){
                    if (!set.contains(entry.getKey())){
                    for (int x = 0; x < integer; x++){
                            sb.append(entry.getKey());
                        }
                        set.add(entry.getKey());
                    }
                }
            }
            if (integer == 1){
                break flag;
            }
        }

        return sb.toString();
    }
}
