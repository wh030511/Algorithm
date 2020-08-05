package exam.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-12-19:51
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int sum = 0;

            if (n == 0){
                for (int i = 0; i < m; i++){
                    sum += sc.nextInt();
                }
                System.out.println(sum);
                break;
            }
            if (m == 0){
                System.out.println(0);
                break;
            }

            int[] save = new int[n];

            for (int i = 0; i < n; i++){
                save[i] = sc.nextInt();
            }

            Arrays.sort(save);
            for (int i = 0; i < m; i++){
                int money = sc.nextInt();
                int index = binarySearch(save, money, 0, save.length - 1);
                if (index != -1){
                    money -= save[index];
                }
                sum += money;
            }

            System.out.println(sum);
        }

    }

    private static int binarySearch(int[] arr, int target, int lo, int hi){
        while(lo < hi){ // 数组存在
            int mi = (lo + hi) >> 1;
            if (target < arr[mi]) hi = mi; // 左边查找
            else lo = mi + 1; // 右边查找 后面的数一定严格大于target
        }
        if (lo == 0) return -1;
        return arr[lo] <= target ? lo : --lo;
    }
}
