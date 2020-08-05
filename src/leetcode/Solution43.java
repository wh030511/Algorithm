package leetcode;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @author WuHao
 * @create 2020-04-22-7:51
 */
public class Solution43 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> num_list = new ArrayList<>();
        for(int num : nums){
            num_list.add(num);
        }
        int n = nums.length;
        backtrack(n , num_list , res , 0);
        return res;
    }

    private void backtrack(int n , List<Integer> nums ,
                           List<List<Integer>> res , int first){
        if(first == n){
            res.add(new ArrayList<Integer>(nums));
        }
        for(int i = first ; i < n; i++){
            Collections.swap(nums , first , i);
            backtrack(n , nums , res , first+1);
            Collections.swap(nums , first , i);
        }
    }
}
