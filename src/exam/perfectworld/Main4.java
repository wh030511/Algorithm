package exam.perfectworld;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-14-20:05
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); // 数据数量
        int load = sc.nextInt(); // 背包重量
        int[] weight = new int[number]; // 物品
        int[] price = new int[number]; // 价格
        for (int i = 0; i < number; i++){
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < number; i++){
            price[i] = sc.nextInt();
        }
        System.out.println(method(number, load, weight, price));
    }
    public static int method(int number , int load , int[] weight , int[] price){
        int[][] dp = new int[load+1][number+1];
        for (int i = 0; i <= number;i++){
            dp[0][i] = 0;
        }
        for (int i = 0; i <= load;i++){
            dp[i][0] = 0;
        }
        for (int i = 1; i <= load; i++){
            for (int j = 1; j <= number;j++){
                if (weight[j-1] <= i){
                    int h = weight[j-1];
                    dp[i][j] = Math.max(price[j-1] + dp[i-h][j-1] , dp[i][j-1]);
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[load][number];
    }
}
