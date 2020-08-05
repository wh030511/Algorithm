package exam.bytedance.prepare;

import org.junit.Test;

import java.util.*;

/**
 * @author WuHao
 * @create 2020-04-29-18:22
 */
public class S15 {
    @Test
    public void test(){
        threeSum(new int[]{-1,0,1});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        for (int index = 0; index < nums.length; index++){

            if (nums[index] > 0) return res; // 剪枝

            if (index > 0 && nums[index] == nums[index-1]) continue; // 剪枝

            int lo = index + 1;
            int hi = nums.length - 1;
            while(lo < hi){
                int value = nums[index] + nums[lo] + nums[hi];
                if (value == 0){
                    while(lo < hi && nums[lo+1] == nums[lo]) lo++;
                    while(lo < hi && nums[hi-1] == nums[hi]) hi--;
                    res.add(Arrays.asList(new Integer[]{nums[index] , nums[lo++] , nums[hi--]}));
                }
                else if (value < 0) lo++;
                else hi--;
            }
        }
        return res;
    }



}
