package exam.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-12-19:31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++){
                arr.add(sc.nextInt());
            }

            helper(arr, 0, arr.size()-1);

            System.out.println(count);

        }
    }

    private static int count = 0;
    private static void helper(List<Integer> list , int left , int right){ // 判断是否递增
        if (left == right) return;

        if (list.get(left) <= list.get(left+1)){
            helper(list, left+1, right);
        }
        else{
            if (left == 0){
                int x = list.get(left + 1);
                int k = list.get(left) / x;
                count += k;
                helper(list, left + 1, right);
            }
            else{
                list.set(left, list.get(left) - list.get(left-1));
                count++;
                helper(list, left, right);
            }
        }
    }
}
