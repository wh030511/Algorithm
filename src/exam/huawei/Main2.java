package exam.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author WuHao
 * @create 2020-04-15-18:51
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String targetStr = sc.next();
            int len = targetStr.length();
            String sourceStr = sc.next();
            String[] sources = sourceStr.split("],");
            List<String> list = new ArrayList<>(); // 存放结果
            flag:
            for (String source : sources) {
                int left = 0;
                for (int i = 0; i < source.length(); i++){
                    if ('[' == source.charAt(i)){
                        left = i;
                        break;
                    }
                }

                if (targetStr.equals(source.substring(0, left))){ // 满足第一个条件
                    String data = source.substring(left+1);
                    if (data.charAt(data.length()-1) == ']'){
                        data = data.substring(0, data.length()-1);
                    }
                    String[] datas = data.split(",");
                    List<String> l = new ArrayList<>(3);

                    for (int index = 0 ; index < 3 ; index++) {
                        if (index == 2){
                            if ("0x".equals(datas[index].substring(4, 6))){
                                l.add(datas[index].substring(4));
                            }else{
                                break flag;
                            }
                        }else{
                            if ("0x".equals(datas[index].substring(5, 7))){
                                l.add(datas[index].substring(5));
                            }else{
                                break flag;
                            }
                        }
                    }

                    list.addAll(l);
                }
            }
            if (list.size() != 0){
                for (int i = 0; i < list.size(); i++){
                    if (i % 3 == 0 && i != 0){
                        System.out.println();
                    }
                    System.out.print(list.get(i) + " ");
                }
            }else{
                System.out.println("FAIL");
            }

        }
    }
}

