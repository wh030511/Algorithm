package exam.alibaba;


import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-03-25-16:09
 */
public class Main {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[3][n];
            for (int j = 0; j < 3; j++){
                for (int i = 0; i < n; i++){
                    arr[j][i] = sc.nextInt();
                }
            }

            int[] dp = new int[n];

            int[] arr1 = new int[3];
            int[] arr2 = new int[3];
            for (int i = 0; i < 3; i++){
                arr1[i] = arr[i][0];
                arr2[i] = arr[i][1];
            }

            int min = Math.abs(arr1[0] - arr2[0]);
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (Math.abs(arr1[i]-arr2[j]) < min ){
                        min = Math.abs(arr1[i]-arr2[j]);
                        dp[0] = arr1[i];
                        dp[1] = arr2[j];
                    }
                }
            }
            res += min;

            for (int i = 2; i < dp.length; i++){
                getDP(dp, arr, i);
            }

            System.out.println(res);
        }
    }



    private static void getDP(int[] dp , int[][] arr , int index){
        int[] tmp = new int[3];
        for (int i = 0; i < 3; i++){
            tmp[i] = arr[i][index];
        }
        int min = Math.abs(dp[index-1] - tmp[0]);
        dp[index] = tmp[0];
        for (int i = 1; i < 3; i++) {
            if(Math.abs(dp[index-1] - tmp[i]) < min ){
                min = Math.abs(dp[index-1] - tmp[i]);
                dp[index] = tmp[i];
            }
        }
        res += min;
    }
}
