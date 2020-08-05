package exam.perfectworld;

import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-14-18:37
 */
public class Main2 {
    public static void main(String[] args){
        int[][] weight = new int[6][];
        String[] pointsStr = {"V1" , "V2" , "V3" , "V4", "V5"};
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < pointsStr.length; i++){
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for(int j = 0; j < valuesStr.length; j++){
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

//        method(weight , pointsStr);
    }

//    public static int[] method(int[][] weightArray , String[] strArray){
//        int[] res = new int[weightArray.length-1];
//        for (int i = 0; i < res.length; i++){
//
//        }
//    }
}
