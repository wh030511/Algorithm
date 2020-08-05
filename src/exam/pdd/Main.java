package exam.pdd;


import java.util.Scanner;

/**
 * @Author WuHao
 * @Create 2020-08-02-18:51
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 距离
        int n = sc.nextInt(); // 次数
        int[] record = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++){
            record[i] = sc.nextInt();
            int[] res = new int[2];
            res = gap(k, record[i]);
            k = res[0];
            count += res[1];
        }

        System.out.println(k + " " + count);
    }

    // 计算本次投掷之后与目标的距离, 同时使用count记录触到中点的次数 (count 只会为1或0)
    private static int[] gap(int target, int num) {
        if (target > num) return new int[]{target - num, 0};
        return new int[]{num - target, 1};
    }
}
