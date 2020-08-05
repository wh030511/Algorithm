package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuHao
 * @create 2020-04-05-9:47
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        Set<List<Integer>> res = new HashSet<>();
        int size = 1 << nums.length;
        for(int i = 0; i < size; i++){
            List<Integer> item = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                if((i&(1 << j)) == (1 << j)){
                    item.add(nums[j]);
                }
            }
            res.add(item);
        }
        List<List<Integer>> r = new ArrayList<>();
        r.addAll(res);
        return r;
    }
}
