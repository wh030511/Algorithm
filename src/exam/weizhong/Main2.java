package exam.weizhong;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Cassidy和Eleanore是一对好朋友，她们经常会一起玩游戏。某一天她们玩了一个回文游戏。
 * 游戏规则是这样的：给出一个仅包含小写字母的字符串S，在每一个人的回合中，她们会进行两个操作：
 * 1. 尝试重新排列这个字符串，如果可以把这个字符串排列成回文字符串，则立即获胜。
 * 2. 否则，她们必须删掉字符串中的一个字符。
 * 已知，Cassidy先手，在两个人都采取最佳策略的情况下，谁可以获胜
 * @author WuHao ac
 * @create 2020-04-21-17:31
 */
public class Main2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while(sc.hasNext()){
            int t = sc.nextInt();
            for (int i = 0; i < t; i++){
                int count = helper();
                if (count % 2 == 1){
                    System.out.println("Cassidy");
                }else{
                    System.out.println("Eleanore");
                }
            }
        }
    }

    private static int helper(){
        String str = sc.next(); // 字符串
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int count = 0; // 记录奇数的个数
        for (Character character : map.keySet()) {
            if (map.get(character) % 2 == 1){
                count++;
            }
        }

        return count;
    }
}
