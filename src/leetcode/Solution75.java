package leetcode;

import org.junit.Test;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author WuHao
 * @create 2020-04-26-9:00
 */
public class Solution75 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void sortColors(int[] nums) {
        int numA = 0;
        int numB = 0;
        int numC = 0;
        for (int num : nums) {
            switch (num){
                case 0:
                    numA++;
                    break;
                case 1:
                    numB++;
                    break;
                case 2:
                    numC++;
                    break;

            }
        }

        int index = 0;

        while(numA-- > 0){
            nums[index++] = 0;
        }
        while(numB-- > 0){
            nums[index++] = 1;
        }
        while(numC-- > 0){
            nums[index++] = 2;
        }

    }

    public void sortColors1(int[] nums) {

        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }

    public void sortColors2(int[] nums) {
        if(nums == null || nums.length < 2) return ;

        int left = 0; // 左指针
        int right = nums.length - 1; // 右指针
        int pointer = 0;
        while(left <= right && pointer <= right){
            if (nums[pointer] == 0){
                int tmp = nums[pointer];
                nums[pointer] = nums[left];
                nums[left] = tmp;
                left++;
                pointer++;
            }
            else if (nums[pointer] == 2){
                int tmp = nums[pointer];
                nums[pointer] = nums[right];
                nums[right] = tmp;
                right--;
            }
            else pointer++;
        }
    }

}
