package exam.perfectworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author WuHao
 * @create 2020-04-14-18:36
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str1 = s.split(" ");
        int[] weights = new int[str1.length];
        for (int i = 0; i < str1.length; i++){
            weights[i] = Integer.parseInt(str1[i]);
        }
        int maxLoad = Integer.parseInt(br.readLine());
        int count = countLeastBoat(weights, maxLoad);
        System.out.println(count);
    }
    public static int countLeastBoat(int[] weights , int maxLoad){
        int num = 0;
        int left = 0;
        int right = weights.length - 1;
        Arrays.sort(weights);
        while(left <= right){
            if(weights[left] + weights[right] <= maxLoad){
                left++;
                right--;
            }
            else{
                right--;
            }
            num++;
        }
        return num;
    }
}
