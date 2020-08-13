package exam.bilibili;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author WuHao
 * @Create 2020-08-13 19:30
 *
 * 判断字符串是否有效
 *
 * result: ac
 */
public class Main2 {
    public boolean IsValidExp (String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if (stack.size() == 0 || !helper(stack.peek() , s.charAt(i))) return false;
                else stack.pop();
            }
        }

        return stack.size() == 0;

    }

    private boolean helper(char a , char b){
        if(a == '(' && b != ')') return false;
        if(a == '[' && b != ']') return false;
        if(a == '{' && b != '}') return false;
        return true;
    }
}
