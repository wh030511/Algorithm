package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @author WuHao
 * @create 2020-04-02-9:35
 */
public class Solution78 {

    @Test
    public void test(){
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    ArrayList<List<Integer>> result = new ArrayList<>();
    int n , k ;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        for(k = 0 ; k < n + 1 ; ++k){
            backtrack(0 , new ArrayList<Integer>() , nums);
        }

        return result;
    }


    public void backtrack(int first, List<Integer> curr , int[] nums){
        if(curr.size() == k) result.add(new ArrayList<>(curr));

        for(int m = first; m < n; ++m){
            curr.add(nums[m]);
            backtrack(m + 1 , curr , nums);
            curr.remove(curr.size() - 1);
        }

    }
}
