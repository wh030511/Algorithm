package exam.huawei;

import java.util.*;

/**
 * @author WuHao
 * @create 2020-04-15-18:51
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        flag:
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] names = str.split(",");
            Map<String , Integer> map = new HashMap<>();
            for (String name : names) {
                if (helper(name)){
                    map.put(name, map.getOrDefault(name, 0) + 1);
                }else{
                    System.out.println("error.0001");
                    continue flag;
                }
            }
            Arrays.sort(names , new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (map.get(o1) != map.get(o2)){ // 票数不等
                        return map.get(o2) - map.get(o1);
                    }else{
                        return o1.compareTo(o2);
                    }
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });
            System.out.println(names[0]);
        }
    }

    private static boolean helper(String name){ // 判断名字合法
        if (name == null || name.length() == 0) return false;
        if (name.charAt(0) < 'A' || name.charAt(0) > 'Z' ) return false;
        for (int i = 1; i < name.length(); i++){
            if (name.charAt(i) < 'a' || name.charAt(i) > 'z') return false;
        }
        return true;
    }
}
