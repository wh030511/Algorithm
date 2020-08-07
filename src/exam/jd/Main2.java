package exam.jd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author WuHao
 * @Create 2020-08-06-20:02
 * 现有一个正整数，希望去掉这个数中某一个数字之后可以得到一个回文素数。
 *
 * 回文素数是指一个素数同时还是一个回文数（回文数即从左到右和从右到左均一样的数，例如12321）。
 * 【注意：一位数也被认为是回文数】
 *
 * 输入两个正整数N和M，满足N<M，请编写一个程序统计N和M之间存在多少个满足上述要求的数？
 *
 * result: 0.91
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        int ceiling = sc.nextInt();
        int count = 0;
        flag:
        for (int i = floor; i <= ceiling; i++) {
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                int value = Integer.parseInt(str.substring(0, j) + str.substring(j + 1));
                if (illegal(value) && loopNum(value)) {
                    count++;
                    continue flag;
                }
            }
        }

        System.out.println(count);
    }

    // 判断一个数是不是素数
    private static boolean illegal(int num) {
        if (num == 1 || num == 0) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 判断一个数是不是回文数
    private static boolean loopNum(int num) {
        char[] arr = Integer.toString(num).toCharArray(); // 将数字转成字符数组
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
