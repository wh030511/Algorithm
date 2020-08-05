package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 * @author WuHao
 * @create 2020-04-17-18:33
 */
public class Solution39 {

    @Test
    public void test(){
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) return null;

        int len = candidates.length;

        Arrays.sort(candidates);
        Deque<Integer> stack = new ArrayDeque<>();
        helper(candidates , target , stack , len , 0);
        return res;
    }

    private void helper(int[] arr , int residum , Deque<Integer> item , int len , int begin){
        if(residum == 0){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i = begin; i < len; i++){

            if(residum < arr[i]){
                break;
            }

            item.add(arr[i]);

            helper(arr , residum - arr[i] , item , len , i);

            item.removeLast();
        }
    }
}
