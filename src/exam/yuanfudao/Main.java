package exam.yuanfudao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-08-01-19:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int courseCount = sc.nextInt(); // 课程数
        int[][] timeTable = new int[courseCount][2];
        for (int i = 0; i < courseCount; i++) { // 输入时间表
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }
        int count = helper(timeTable);
        System.out.println(count);
    }

    private static int helper(int[][] points) {

        if (points.length == 0) return 0; // 特判

        Arrays.sort(points, new Comparator<int[]>() { // 以开始时间排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int maxCount = 1; // 记录需要的心数
        int maxValue = 0; // 找到最大值
        for (int i = 0; i < points.length; i++) {
            maxValue = Math.max(maxValue, points[i][1]);
        }

        for (int i = points[0][0]; i < maxValue; i++) {
            float value = (float)(i + 0.5);
            int tempMaxCount = 0;
            for (int index = 0; index < points.length; index++) {
                if (points[index][0] > value) break;
                if (points[index][1] > value) {
                    tempMaxCount++;
                }
            }
            maxCount = Math.max(maxCount, tempMaxCount);
        }

        return maxCount;
    }
}
