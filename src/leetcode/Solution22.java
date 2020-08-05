package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuHao
 * @create 2020-04-07-17:53
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        gengrate("" , n , n);
        return res;
    }

    private List<String> res = new ArrayList<>();
    private void gengrate(String item , int ln , int rn){
        if(ln == 0 && rn == 0){
            res.add(item);
            return ;
        }
        if(ln > 0){
            gengrate(item + "(" , ln-1 , rn);
        }
        if(rn > 0 && ln < rn){
            gengrate(item + ")" , ln , rn -1);
        }
    }
}
