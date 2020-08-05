package exam.huawei;

import java.util.*;

/**
 * @author WuHao
 * @create 2020-04-15-18:51
 */
public class Main3 {
    static Map<Integer , Integer[]> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        flag:
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] len = new int[n];
            for (int i = 0; i < n; i++){
                len[i] = sc.nextInt();
            }
            for (int i = 0; i < n ; i ++){
                int key = sc.nextInt();
                Integer[] nums = new Integer[len[i]+1];
                for (int k = 0; k < nums.length; k++){
                    nums[k] = sc.nextInt();
                }
                if (nums.length == 0){
                    System.out.println("NA");
                    continue flag;
                }
                map.put(key, nums);
            }
            helper(count , 1 , 1);
            int max = 0;
            for (Integer re : res) {
                System.out.println(re);
            }


            System.out.println("R");
        }
    }

    private static int count = 0;
    private static List<Integer> res = new ArrayList<>();
    private static void helper(int count , int index , int k){
        Integer[] integers = map.get(index);
        k = 1;

        if (index == map.size() || integers.length == 1){
            count += integers[0];
            res.add(count);
            count = 0;
            return;
        }


        helper(count+integers[0] , integers[k] , k);

        while (k < integers.length - 1){
            k++;
            helper(count+integers[0] , integers[k] , k);
        }
        return;
    }
}
