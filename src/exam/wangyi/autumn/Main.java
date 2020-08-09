package exam.wangyi.autumn;

import java.util.Scanner;

/**
 * @Author WuHao
 * @Date 2020-08-08-14:18
 *一个数组a，其中的每个元素都可以拆成若干个和为a[i]的正整数，求拆后这个数组最多能有多少个素数
 *
 * result: 0.3
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(); //数组长度
        int res = 0;
        for (int i = 0; i < len; i++) {
            int value = sc.nextInt();
            res += value / 2;
        }
        System.out.println(res);
    }

}
