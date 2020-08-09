package exam.wangyi.autumn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author WuHao
 * @Date 2020-08-08-15:18
 *
 * 给定长度为m的序列T，求一个长度为n且字典序最小的排列，并且要求序列T为所求排列的子序列。
 * 题目保证这样的排列一定存在，S是T的子序列，当且仅当S是T通过删除任意数量元素所得到的。
 * 字典序是单词在字典中的排列顺序，先比较第一个字母，然后比较第二个字母，以此类推。
 *
 * result: 0.3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> origin = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            origin.add(sc.nextInt());
        }
        flag:
        for (int i = 1; i <= n; i++) {
            if (origin.contains(i)) continue;
            for (int index = 0; index < origin.size(); index++) {
                if (i < origin.get(index)){
                    origin.add(index, i);
                    continue flag;
                }
            }
            origin.add(i);
        }
        for (int i = 0; i < origin.size()-1; i++) {
            System.out.print(origin.get(i) + " ");
        }
        System.out.println(origin.get(origin.size()-1));
    }
}
