package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author WuHao
 * @create 2020-04-16-21:37
 */
public class Solution20 {
    public boolean isValid(String s) {
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
