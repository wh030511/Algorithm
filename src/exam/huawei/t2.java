package exam.huawei;

import java.util.*;
public class t2 {

    private static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String mode = null;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ' '){
                mode = s.substring(0, i);
            }else{
                continue;
            }
            s = s.substring(i + 1);
            break;
        }
        while(!s.isEmpty()){
            for(int i = 0;i < s.length();i++){
                if(s.charAt(i) == '['){
                    if(mode.equals(s.substring(0, i))){
                        s = s.substring(i + 1);
                        output(s);
                    }
                    for(int j = i;j < s.length();j++){
                        if(s.charAt(j) == ']'){
                            if(j == s.length() - 1){
                                s = s.substring(j + 1);
                            }else{
                                s = s.substring(j + 2);
                            }
                        }
                    }
                }
            }
        }
        if(!flag){
            System.out.println("FAIL");
        }
    }
    private static void output(String s){
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0;i < s.length();i++){
            if(a == 0 && s.charAt(i) == ','){
                a = i;
                continue;
            }
            if(a != 0 && s.charAt(i) == ','){
                b = i;
                continue;
            }
            if(a != 0 && b != 0 && s.charAt(i) == ']'){
                c = i;
                break;
            }
        }
        if(s.substring(0, 4).equals("addr") && s.substring(a + 1, a + 5).equals("mask") && s.substring(b + 1, b + 4).equals("val")){
            if((s.substring(5, 7).equals("0x") || s.substring(5, 7).equals("0X")) && (s.substring(a + 6, a + 8).equals("0x") || s.substring(a + 6, a + 8).equals("0X")) && (s.substring(b + 5, b + 7).equals("0x") || s.substring(b + 5, b + 7).equals("0X"))){
                System.out.println(s.substring(5, a) + " " + s.substring(a + 6, b) + " " + s.substring(b + 5, c));
                flag = true;
            }
        }
    }

}
