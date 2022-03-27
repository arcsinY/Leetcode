// dp[i][0]：第 i 天手里没有股票，能够获得的最大利润
// dp[i][1]：第 i 天手里有股票，能够获得的最大利润
// dp[i][0] = max(dp[i-1][1]+prices[i], dp[i-1][0])，表示第 i 天手里没有股票可能是：1. 前一天手里有，今天卖掉了。2. 前一天没有，今天也没买
// dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])，表示第 i 天手里有股票可能是：1. 前一天手里没有，今天买了。2. 前一天有，今天也没卖
// 将 dp[i][0] 转化为 dp0，dp[i][1] 转化为 dp1
class Solution {
    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int t = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(t - prices[i], dp1);
        }
        return dp0;
    }
}
