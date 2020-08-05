package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-04-12-11:51
 */
public class Solution34 {

    @Test
    public void test(){
        int[] ints = searchRange(new int[]{1}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mi = (lo + hi) >> 1;
            if(target == nums[mi]){
                int left = mi;
                int right = mi;
                while(left >= lo && nums[left] == target){
                    res[0] = left;
                    left--;
                }
                while(right <= hi && nums[right] == target){
                    res[1] = right;
                    right++;
                }
                return res;
            }
            if(nums[mi] < target){
                lo = mi + 1;
            }
            if(target < nums[mi]){
                hi = mi - 1;
            }
        }
        return res;
    }
}
