package exam.meituan;

import java.util.Scanner;

/**
 * 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
 * <p>
 * 1． 向右走一格，即从(x,y)到(x,y+1);
 * <p>
 * 2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
 * <p>
 * 3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
 * <p>
 * <p>
 * <p>
 * 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
 *
 * @author WuHao
 * @create 2020-03-12-18:10
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str1 = sc.next();
            String str2 = sc.next();
            boolean[][] dp = new boolean[2][n];
            init(dp,str1.toCharArray(),str2.toCharArray());
            if(dp[0][0] == false){
                System.out.println(-1);
                continue;
            }
            int[][] res = new int[2][n];
            res[0][0] = 1;
            res[1][0] = 0;
            for(int i = 1; i < n;i++){
                if(dp[0][i]){
                    res[0][i] = res[0][i-1] + res[1][i-1];
                }else{
                    res[0][i] = 0;
                }
                if(dp[1][i]){
                    res[1][i] = res[1][i-1] + res[0][i-1];
                }else{
                    res[1][i] = 0;
                }
            }
            if(res[1][n-1] == 0) {
                System.out.println(-1);
                continue;
            }
            System.out.println(res[1][n-1]);
        }
    }

    private static void init(boolean[][] dp ,char[] ch1,char[] ch2){
        for(int i = 0; i < ch1.length; i++){
           if(ch1[i] == '.') dp[0][i] = true;
           if(ch2[i] == '.') dp[1][i] = true;
        }
    }
}
