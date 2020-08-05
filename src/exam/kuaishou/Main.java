package exam.kuaishou;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-03-22-18:18
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] nums = str.split(" ");
            int[] ints = new int[nums.length];
            if (ints.length < 2) System.out.println(-1);
            boolean flag = true;
            for (int i = 0; i < nums.length; i++){
                ints[i] = Integer.parseInt(nums[i]);
            }
            int max = ints[0];
            int c_max = ints[1];
            if (ints[1] < ints[0]){
                flag = false;
                System.out.print(1 + " ");
                max = ints[1];
                c_max = ints[0];
            }
            for (int i = 2; i < ints.length; i++){
                if (c_max <= ints[i] && ints[i] < max){
                    System.out.print(i + " ");
                    flag = false;
                }
                if (ints[i] > max){
                    c_max = max;
                    max = ints[i];
                }
            }
            if (flag){
                System.out.println(-1);
            }
        }
    }
}
