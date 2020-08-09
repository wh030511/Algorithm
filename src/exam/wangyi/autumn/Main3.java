package exam.wangyi.autumn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author WuHao
 * @Date 2020-08-08-15:48
 *
 * 现有n个物品，每一个物品都有一个价值，现在想把这些物品分给两个人。
 * 要求这两个人每个人分到的物品的总价值相同。个数可以不同，总价值相等即可），剩下的物品就要扔掉。
 * 现在想知道最少需要扔多少价值的物品才能满足要求分给两个人。
 *
 * 好难,不会
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int index = 0;
        while (index++ < T) {
            int n = sc.nextInt();
            int[] value = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                value[i] = sc.nextInt();
                total += value[i];
            }
            Arrays.sort(value);
            int totalA = 0;
            int totalB = 0;
            int res = Integer.MAX_VALUE;
            for (int i = n-1; i >= 0; i--) {
                if (totalA < totalB && totalB - totalA >= value[i]) totalA += value[i];
                else totalB += value[i];
                if (totalA == totalB) {
                    res = Math.min(res, total - 2 * totalA);
                }
            }
            System.out.println(res);
        }
    }


}
