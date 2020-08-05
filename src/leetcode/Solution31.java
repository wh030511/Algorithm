package leetcode;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * @author WuHao
 * @create 2020-04-16-22:44
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        boolean flag = false;

        for(int i = nums.length - 1; i > 0 ; i--){
            if(nums[i] > nums[i-1]){
                int index;
                for(index = nums.length -1 ; index >= i; index--){ // 找到第一个大于nums[i-1]的位置
                    if(nums[index] > nums[i-1]) break;
                }
                flag = true;
                swap(nums , i - 1 , index);
                reverse(nums , i);
                break;
            }
        }
        if(!flag){
            Arrays.sort(nums);
        }
    }

    private void reverse(int[] arr , int start){
        int left = start;
        int right = arr.length-1;
        while(left < right){
            swap(arr , left , right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr , int left , int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
