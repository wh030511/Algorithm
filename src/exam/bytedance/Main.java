package exam.bytedance;


import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-12-18:55
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (sc.hasNext()) {
            int t = sc.nextInt();
            for (int m = 0; m < t; m++){
                helper();
            }
        }
    }

    private static void helper(){
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        int index1L = 0;
        int index2L = 0;
        int index1R = n - 1;
        int index2R = n - 1;
        boolean flag1 = false;
        boolean flag2 = false;
        while (index1L < index1R) {
            if (arr1[index1L] == arr2[index2L]) {
                index1L++;
                index2L++;
            } else {
                flag1 = true;
            }
            if (arr1[index1R] == arr2[index2R]) {
                index1R--;
                index2R--;
            } else {
                flag2 = true;
            }

            if (flag1 && flag2) {
                break;
            }
        }
        int left = index1L;
        int right = index1R;
        if (left == right) {
            System.out.println("YES");
        } else {
            int len = arr1[left] - arr2[left];
            for (int i = left + 1; i <= right; i++) {
                if (arr1[i] - arr2[i] != len) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }
}
