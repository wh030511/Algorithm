package exam.huawei;

import java.util.*;
public class t3 {

    private static int ans = 0;
    private static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] vol = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = in.nextInt();
        }
        in.nextLine();
        ArrayList<ArrayList<Integer>> function = new ArrayList<>();
        for(int i = 0;i < n;i++){
            String s = in.nextLine();
            int f = 0;
            int v = 0;
            loop1:
            for(int j = 0;j < s.length();j++){
                if(s.charAt(j) == ' '){
                    f = Integer.parseInt(s.substring(0, j));
                    s = s.substring(j + 1);
                    break loop1;
                }
            }
            loop2:
            for(int j = 0;j < s.length();j++){
                if(s.charAt(j) == ' '){
                    v = Integer.parseInt(s.substring(0, j));
                    vol[i] = v;
                    s = s.substring(j + 1);
                    break loop2;
                }else if(j == s.length() - 1){
                    v = Integer.parseInt(s.substring(0, j + 1));
                    vol[i] = v;
                    s = s.substring(j + 1);
                    break loop2;
                }
            }
            ArrayList<Integer> temp = new ArrayList<>();
            while(!s.isEmpty()) {
                for(int j = 0;j < s.length();j++){
                    if (s.charAt(j) == ' ') {
                        temp.add(Integer.parseInt(s.substring(0, j)));
                        s = s.substring(j + 1);
                        j++;
                    } else if (j == s.length() - 1) {
                        temp.add(Integer.parseInt(s.substring(0, j + 1)));
                        s = s.substring(j + 1);
                        j++;
                    }
                }
            }
            function.add(temp);
            if(temp.size() < a[i]){
                System.out.println("NA");
                return;
            }
        }
        // 需要判断最大的链栈大小以及是否有环
        // 环可以通过hash来判断
        // 使用递归来求
        HashSet<Integer> h = new HashSet<>();
        for(int k = 0;k < function.size();k++){
            rec(function, k, vol[0], vol, h);
        }

        if(!flag){
            System.out.println(ans);
        }else{
            System.out.println("R");
        }
    }
    private static void rec(ArrayList<ArrayList<Integer>> f,int k, int num, int[] vol, HashSet<Integer> h){
        if(f.get(k).size() == 0){
            ans = Math.max(ans, num);
        }
        for(int i = 0;i < f.get(k).size();i++){
            if(h.contains(f.get(k).get(i))){
                flag = true;
                return;
            }else{
                h.add(f.get(k).get(i));
            }
            rec(f, f.get(k).get(i) - 1, num + vol[f.get(k).get(i) - 1], vol, h);
            h.remove(f.get(k).get(i));
        }
    }

}
