package exam.pdd;


import java.util.*;

/**
 * @Author WuHao
 * @Create 2020-08-02-19:32
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 组数
        HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>(n);
        for (int i = 0; i < n; i++) {
            Integer[] arr = new Integer[6];
            for (int j = 0; j < 6; j++) {
                arr[j] = sc.nextInt();
            }
            map.put(i, arr);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int count = helper(i, map); // 该类数量
            if (count != 0) {
                list.add(count);
            }
        }
        Collections.sort(list); // 排序
        Collections.reverse(list);
        System.out.println(list.size());
//        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size()-1));
    }

    // 判断该类骰子的个数
    private static int helper(Integer index, HashMap<Integer, Integer[]> map) {
        if (index == map.size() - 1) {
            return map.get(index) == null ? 0 : 1;
        }
        if (map.get(index) == null) return 0;
        int res = 1;
        for (int i = index + 1; i < map.size(); i++) {
            if (map.get(i) != null && helper2(map.get(index), map.get(i))) { // 如果是同一类
                map.put(i, null); // 置为空
                res++;
            }
        }
        return res;
    }

    // 判断两个数组是否可以相互转换
    private static boolean helper2(Integer[] arr1, Integer[] arr2) {
        int changeCount = 0;
        for (int i = 0; i < 6; i += 2) {
            for (int j = 0; j < 6; j++) {
                if (arr1[i] == arr2[j]) {
                    int num1 = arr1[i+1];
                    int num2 = j % 2 == 0 ? arr2[j+1] : arr2[j-1];
                    if (num1 != num2) return false;
                    if (i / 2 != j / 2) changeCount++;
                }
            }
        }
        if (changeCount == 0) {
            for (int i = 0; i < 6; i++) {
                if (arr1[i] != arr2[i]) return false;
            }
        }
        return true;
    }
}
