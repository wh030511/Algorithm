package exam.kuaishou;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-03-22-20:08
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] nums = str.split("\\,");
            Arrays.sort(nums,new Comparator<String>(){

                @Override
                public int compare(String str1, String str2) {
                    return getValue(str2.substring(3)) - getValue(str1.substring(3));
                }
            });

            for (String num : nums) {
                if (getValue(str.substring(3)) >= 6){
                    System.out.println(num);
                }
            }


        }
    }

    private static int getValue(String str){
        int[] dp1 = new int[str.length()];
        dp1[0] = 0;
        dp1[1] = 0;
        if (str.charAt(3) == str.charAt(2) && str.charAt(2) == str.charAt(1)){
            dp1[2] = 7;
        }else{
            dp1[2] = 0;
        }
        for (int i = 3; i < str.length(); i++){
            if (str.charAt(i) == str.charAt(i-1)){
                dp1[i] = dp1[i-1] + 2;
            }else{
                dp1[i] = 0;
            }
        }

        int[] dp2 = new int[str.length()];
        dp2[0] = 0;
        dp2[1] = 0;
        if (Integer.parseInt(str.charAt(3)+"") == Integer.parseInt(str.charAt(2)+"")+1
                && Integer.parseInt(str.charAt(2)+"") == Integer.parseInt(str.charAt(1)+"") + 1){
            dp2[2] = 6;
        }else{
            dp2[2] = 0;
        }
        for (int i = 3; i < str.length(); i++){
            if (Integer.parseInt(str.charAt(i)+"") == Integer.parseInt(str.charAt(i-1)+"")+1){
                dp2[i] = dp2[i-1] + 2;
            }else{
                dp2[i] = 0;
            }
        }

        int max1 = dp1[0];
        int max2 = dp2[0];
        for (int i = 1; i < dp1.length;i++){
            if (dp1[i] > max1){
                max1 = dp1[i];
            }
            if (dp2[i] > max2){
                max2 = dp2[i];
            }
        }
        return Math.max(max1, max2);
    }

}
