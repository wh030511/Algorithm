package leetcode;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-04-13-10:26
 */
public class Solution33 {

    @Test
    public void test(){
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                index = i;
                break;
            }
        }
        if(target < nums[nums.length - 1]){
            return binarySearch(nums , target , index + 1 , nums.length - 1);
        }else{
            return binarySearch(nums , target , 0 , index);
        }
    }

    private int binarySearch(int[] arr , int target , int lo , int hi){
        while(1 < (hi - lo)){
            int mi = (lo + hi) >> 1;
            if(target < arr[mi]) hi = mi;
            else lo = mi;
        }
        return (target == arr[lo]) ? lo : -1;
    }
}
