package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠
 * @author WuHao
 * @create 2020-03-26-9:19
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        Arrays.sort(intervals , new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];

        for (int i =1 ; i < intervals.length; i++){
            if (intervals[i][0] < end){
                continue;
            }
            count += 1;
            end = intervals[i][1];
        }


        return intervals.length - count;
    }
}
