package exam.wangyi;

import java.util.*;

/**
 * @author WuHao
 * @create 2020-04-07-20:00
 */
public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>(); // 存放感染者的编号
        set.add(0);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int f = sc.nextInt();
            for(int i = 0; i < m ; i++){ // 输入m行
                int q = sc.nextInt(); // 聚会人数
                boolean flag = false; // 该聚会无感染者参与
                List<Integer> persons = new ArrayList<>(); // 参与人员的编号
                for(int p = 0; p < q; p++){
                    int num = sc.nextInt();
                    if (set.contains(num)) flag = true; // 有感染者参与
                    persons.add(num);
                }
                if (flag){ // 有感染者参与
                    set.addAll(persons);
                }
            }
            System.out.println(set.size());
        }
    }
}
