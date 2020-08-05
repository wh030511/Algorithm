package exam.huawei;

import java.util.*;
public class t1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // 用hash计数，用数组存储当前最大数所对应的名字，
        // 如果遇到数相同，则比较两个字母的大小，留下较小的字母
        HashMap<String, Integer> map = new HashMap<>();
        String ans = null;
        int num = 0;
        while(s.length() != 0){
            loop:
            for(int i = 0;i < s.length();i++){
                if(s.charAt(i) == ',' || i == s.length() - 1){
                    String temp = null;
                    if(s.charAt(i) == ','){
                        temp = s.substring(0, i);
                        s = s.substring(i + 1);
                    }else{
                        temp = s.substring(0, i + 1);
                        s = s.substring(i + 1);
                    }
                    if(temp.charAt(0) < 'A' || temp.charAt(0) > 'Z'){
                        System.out.println("error.0001");
                        return;
                    }
                    for(int j = 1;j < temp.length();j++){
                        if(temp.charAt(j) < 'a' || temp.charAt(0) > 'z'){
                            System.out.println("error.0001");
                            return;
                        }
                    }
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp) + 1);
                    }else{
                        map.put(temp, 1);
                    }
                    if(ans != null){
                        if(map.get(temp) > num){
                            num = map.get(temp);
                            ans = temp;
                        }else if(map.get(temp) == num){
                            // 比较temp和ans哪个小
                            int t = 0;
                            int a = 0;
                            rec:
                            while(t < temp.length() && a < ans.length()){
                                if(temp.charAt(t) < temp.charAt(a)){
                                    num = map.get(temp);
                                    ans = temp;
                                    break rec;
                                }else if(temp.charAt(t) == temp.charAt(a)){
                                    t++;
                                    a++;
                                }
                            }
                            if(t >= temp.length()){
                                num = map.get(temp);
                                ans = temp;
                            }
                        }
                    }else{
                        ans = temp;
                        num = map.get(temp);
                    }
                    break loop;
                }
            }
        }
        System.out.println(ans);
    }

}
