package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author WuHao
 * @create 2020-05-22-8:09
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        Arrays.sort(intervals , new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) { // 升序排列
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            int lo = intervals[i][0]; // 左边
            int hi = intervals[i][1]; // 右边
            while (i < intervals.length - 1 && hi >= intervals[i+1][0]) hi = Math.max(intervals[++i][1] , hi);
            res.add(new int[]{lo , hi});
        }
        int[][] ans = new int[res.size()][2];
        int index = 0;
        for (int[] re : res) {
            ans[index++] = re;
        }
        return ans;
    }
}
