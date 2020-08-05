package exam.shappe;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给一个整数数组，找出最小的不在数组中的正整数
 *
 * result: ac
 */
public class Main {
    public static void main(String[] args) {

    }

    public int firstMissingPositive (int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; ; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
    }
}
