package exam.wangyi;


import org.junit.Test;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-07-19:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        flag:
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 1) continue flag;
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] nums = new int[n-1];
            for(int i = 0; i < n - 1 ; i++){
                nums[i] = arr[i+1] - arr[i];
                if(nums[i] < 0){
                    System.out.println(-1);
                    continue flag;
                }
            }
            int[] dp = new int[n-1];
            dp[0] = nums[0];
            for(int i = 1 ; i < dp.length; i++){
                dp[i] = getNum(dp[i-1] , nums[i]);
                if(dp[i] == 1){
                    System.out.println(1);
                    continue flag;
                }
            }
            System.out.println(dp[dp.length-1]);
        }
    }

    private static int getNum(int a , int b){
//        for(int k = 1 ; k <= a; k++){
//            if(a % k == 0 && (b % (a / k) == 0)){
//                return (a / k);
//            }
//        }
//        return 1;
        return -1;
    }

    @Test
    public void test(){
        System.out.println(Math.multiplyExact(6, 8));
    }
}
