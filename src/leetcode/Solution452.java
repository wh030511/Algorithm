package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 射击气球
 * @author WuHao
 * @create 2020-03-15-10:36
 */
public class Solution452 {
    @Test
    public void test(){

    }

    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) return 0; // 特判

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 1; // 记录所需要的箭数
        int[] area = new int[2]; // 维护一个射击区间
        area[0] = points[0][0];
        area[1] = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] >= area[1]){ // 射击区间不够了
                count++;
                area[0] = points[i][0];
                area[1] = points[i][1];
                continue;
            }
            // 缩小射击区间
            area[0] = Math.max(area[0],points[i][0]);
            area[1] = Math.min(area[1],points[i][1]);
        }

        return count;
    }
}
