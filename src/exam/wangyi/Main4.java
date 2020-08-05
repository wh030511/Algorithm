package exam.wangyi;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-07-20:11
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arrs = new int[n][m];
            int[][] dp = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int num = sc.nextInt();
                    arrs[i][j] = num;
                    dp[i][j] = -1;
                }
            }
            for(int i = 0 ; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(dp[i][j] == -1){
                        if((i-1) >= 0 && dp[i-1][j] != -1) dp[i-1][j] = 1;
                        if((j-1) >= 0 && dp[i][j-1] != -1) dp[i][j-1] = 1;
                        if((i+1) < n && dp[i+1][j] != -1) dp[i+1][j] = 1;
                        if((j+1) < m && dp[i][j+1] != -1) dp[i][j+1] = 1;
                        dp[i][j] = 0;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(dp[i][j]);
                }
                System.out.println();
            }

        }
    }
}
