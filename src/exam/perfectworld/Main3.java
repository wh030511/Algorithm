package exam.perfectworld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-14-19:42
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Integer[][] array = new Integer[x][2];
        for (int i = 0; i < x; i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        System.out.println(maxEnvelopes(array));
    }
    public static int maxEnvelopes(Integer[][] array){
        Arrays.sort(array , new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        int box = 0;
        for (int i = 0; i < array.length; i++){
            int[] flag = new int[]{array[i][0],array[i][1]};
            if (array[i][0] != -1){ // 当此数未被装入箱中
                for (int j = i + 1; j < array.length; j++){
                    if (array[j][0] > flag[0] && array[j][1] > flag[1]){
                        flag[0] = array[j][0];
                        flag[1] = array[j][1];
                        array[j][0] = -1;
                    }
                }
                box++;
            }
        }
        return box;
    }
}
