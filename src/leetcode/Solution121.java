package leetcode;

import org.junit.Test;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 * @author WuHao
 * @create 2020-03-26-10:18
 */
public class Solution121 {

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int[] dp = new int[prices.length];
        int min = prices[0];
        int max = 0;

        for (int i = 1; i < dp.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            dp[i] = min;
            max = prices[i] - min > max ? prices[i] - min : max;
        }

        return max;
    }
}
