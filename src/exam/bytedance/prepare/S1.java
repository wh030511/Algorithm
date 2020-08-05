package exam.bytedance.prepare;

import java.util.HashMap;

/**
 * @author WuHao
 * @create 2020-04-27-21:34
 */
public class S1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            map.put( nums[i] - target , i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i){
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
