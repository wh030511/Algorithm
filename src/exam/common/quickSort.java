package exam.common;

import org.junit.Test;

import java.util.Random;

/**
 * @author WuHao
 * @create 2020-03-23-12:17
 */
public class quickSort {
    @Test
    public void test(){
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++){
            nums[i] = random.nextInt(100);
        }
        quickS(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void quickS(int[] nums, int i, int j){
        if (i >= j) return;
        int left = i;
        int right = j;
        int target = nums[(i+j)>>1];
        while(left < right){
            while(target < nums[right] && left < right) right--;
            while(nums[left] < target && left < right) left++;

            if (left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[(i+j)>>1] = nums[left];
        nums[left] = target;

        quickS(nums, i, left-1);
        quickS(nums, left+1, j);
    }
}
