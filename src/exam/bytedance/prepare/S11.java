package exam.bytedance.prepare;

import org.junit.Test;

/**
 * @author WuHao
 * @create 2020-04-29-18:01
 */
public class S11 {
    @Test
    public void test(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) { // 双指针
        int res = 0;
        int lo = 0 ;
        int hi = height.length - 1;
        while(lo < hi){
            int V = (hi - lo) * Math.min(height[lo], height[hi]);
            res = res > V ? res : V;
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }
        return res;
    }
}
