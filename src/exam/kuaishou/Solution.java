package exam.kuaishou;

/**
 * @author WuHao
 * @create 2020-03-22-19:04
 */
public class Solution {
    public int[] DistanceToHigher (int[] height) {
        if (height == null) return null;
        int[] dp = new int[height.length];
        int[] res = new int[height.length];
        dp[0] = -1; //当没有比他高的人时 dp表置为-1
        for (int i = 1; i < dp.length; i++){
            if (height[i] < height[i-1]){
                dp[i] = i-1;
                continue;
            }
            int index = dp[i-1];
            while(true){
                if (index == -1){
                    dp[i] = -1;
                    break;
                }
                if (height[i] < height[index]){
                    dp[i] = index;
                    break;
                }else{
                    index = dp[index];
                }
            }
        }
        for (int i = 0; i < dp.length; i++){
            res[i] = dp[i] == -1 ? 0:i-dp[i];
        }
        return res;
    }
}
