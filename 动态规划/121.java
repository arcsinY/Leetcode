// 动态规划：dp[i]表示第i天卖出股票能获得的最大收益，dp[i] = price[i] - min，min是第i天之前的最低价格
// 不需要记录所有的dp[i]，只需要选取最大的，因此dp数组可以改为只记录1个最大的数
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }
}
