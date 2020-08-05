package leetcode;

/**
 * 摇摆序列
 * @author WuHao
 * @create 2020-03-13-11:02
 */


public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = -1;
        // 特判
        if(nums.length < 3) return nums.length;

        int STATUS = BEGIN;
        int res = 1;
        for(int i = 1 ; i < nums.length;i++){
            switch(STATUS){
                case BEGIN:
                    if(nums[i-1] > nums[i]){
                        STATUS = DOWN;
                        res++;
                    }
                    else if(nums[i-1] < nums[i]){
                        STATUS = UP;
                        res++;
                    }
                    break;
                case UP:
                    if(nums[i-1] > nums[i]){
                        STATUS = DOWN;
                        res++;
                    }
                    break;
                case DOWN:
                    if(nums[i] > nums[i-1]){
                        STATUS = UP;
                        res++;
                    }
                    break;

            }
        }
        return res;
    }
}
