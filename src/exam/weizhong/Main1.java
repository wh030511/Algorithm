package exam.weizhong;

import java.util.Scanner;

/**
 * 有n位小朋友去小明家里拜年，小明准备了m份礼物。小明想把所有礼物平均分给每个小朋友，每个小朋友得到相同个数的礼物。
 * 但是m未必能被n整除，
 * 小明可以使用以下两种操作任意多次（两种操作可以同时使用）。
 * 1、 给其中一个小朋友发红包，收到红包的小朋友会离开小明家。每个红包需要花费a元。
 * 2、 购买一个新礼物，每个礼物价值为b元。
 * 问小明最少花费多少元，才能使得所有礼物可以被剩下的小朋友平分。
 *
 * @author WuHao  ac
 * @create 2020-04-21-17:31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int count = 0;
            if (m % n == 0) {
                System.out.println(count);
                continue;
            }

            int person = 0;
            for (int i = 0 ; ; i++){
                if (m % (n - i) == 0){
                    break;
                }
                person++;
            }

            int cost1 = person * a;
            int cost2 = (n - (m % n)) * b;
            System.out.println(Math.min(cost1, cost2));
    }
}
}
