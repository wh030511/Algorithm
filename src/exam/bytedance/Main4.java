package exam.bytedance;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-12-20:23
 */
public class Main4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while(sc.hasNext()){
            int t = sc.nextInt();
            for (int i = 0; i < t ; i++){
                helper();
                System.out.println();
            }
        }
    }

    private static void helper(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        for (int index = 0; index < n; index++){
            int left = 0;
            int right = 0;
            for (int i = index - 1; i >= 0; i--){
                if (arr[i] <= arr[index]){
                    left++;
                }
                else break;
            }
            for (int i = index + 1; i <= n-1 ; i++){
                if (arr[i] <= arr[index]){
                    right++;
                }
                else break;
            }
            dp[index] = left + right;
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
    }
}
