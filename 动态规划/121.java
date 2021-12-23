// 动态规划：dp[i]表示第i天卖出股票能获得的最大收益，dp[i] = price[i] - min，min是第i天之前的最低价格
// 不需要记录所有的dp[i]，只需要选取最大的，因此dp数组可以改为只记录1个最大的数
public class Solution {
    public int maxProfit (int[] prices) {
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
