package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * @author WuHao 三数之和
 * @create 2020-02-17-11:52
 */

public class Solution15 {
    @Test
    public void test() {
        for (List<Integer> integers : threeSum(new int[]{-2,0,0,2,2})) {
            for (Integer i : integers) {
                System.out.println(i);
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&");
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {

        // result 存放结果数据
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < 3) return result; // 不够三个数
        Arrays.sort(nums);
        if (nums[0] > 0) return result; //明显不存在答案

        int i = 0;
        while (nums[i] <= 0) {
            int target = -nums[i]; //target是两数之和
            int left = i + 1;
            int right = nums.length - 1;

            // 两数之和
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    // 做一个不重复的判断
                    if (!isExist(result, list)) result.add(list); // 将满足条件的值放进去 并继续向中靠拢查询其他
                }
                if (nums[left] + nums[right] > target) right--;
                if (nums[left] + nums[right] < target) left++;
            }
            i++;
        }

        return result;
    }

    public boolean isExist(List<List<Integer>> dataSource, List<Integer> newData) {
        if (dataSource.size() == 0) return false;
        // 主要用来判断是否存在相同数据
        List<Integer> newList = dataSource.get(dataSource.size() - 1);
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i) != newData.get(i)) return false;
        }
        return true;
    }
}