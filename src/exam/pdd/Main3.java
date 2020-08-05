package exam.pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author WuHao
 * @Create 2020-08-02-20:05
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lunchCount = sc.nextInt();
        int dinnerCount = sc.nextInt();
        int target = sc.nextInt(); // 美味值
        int[][] lunch = new int[lunchCount][2];
        int[][] dinner = new int[dinnerCount][2];
        for (int i = 0; i < lunchCount; i++) {
            lunch[i][0] = sc.nextInt();
            lunch[i][1] = sc.nextInt();
        }
        for (int i = 0; i < dinnerCount; i++) {
            dinner[i][0] = sc.nextInt();
            dinner[i][1] = sc.nextInt();
        }
        if (target == 0) {
            System.out.println(0);
            return;
        }
        // 分别对lunch和dinner以美味值排序
        Arrays.sort(lunch, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        Arrays.sort(dinner, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        int minT = Integer.MAX_VALUE; // 记录最小的热量值
        if (lunch[0][1] + dinner[0][1] < target) {
            System.out.println(-1);
            return;
        }
        flag:
        for (int i = 0; i < lunchCount; i++){
            for (int j = 0; j < dinnerCount; j++) {
                if (lunch[i][1] + dinner[j][1] < target) continue flag;
                minT = Math.min(lunch[i][0]+dinner[j][0], minT);
            }
        }
        for (int i = 0; i < lunchCount; i++) {
            if (lunch[i][1] >= target) {
                minT = Math.min(lunch[i][0], minT);
            }
        }
        for (int i = 0; i < dinnerCount; i++){
            if (dinner[i][1] >= target) {
                minT = Math.min(dinner[i][0], minT);
            }
        }
        System.out.println(minT);
    }
}
