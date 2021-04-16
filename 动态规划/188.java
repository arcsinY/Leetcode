// dp[i][j][0]：第i天时，允许进行j次交易，手中没有股票的收益
// dp[i][j][1]：第i天时，允许进行j次交易，手中有股票的收益
class Solution {
    public int maxProfit(int k, int[] prices) {
        // 避免数组过大，当k>一半的天数时k没有意义，可以无限多次交易
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        // 第一天有股票，一定是以第一天的价格买的
        for (int i = 1; i <= k; ++i) {
            dp[0][i][1] = -prices[0];
        }
        // 不允许交易，手里不可能有股票。用最小值表示非法情况
        for (int i = 0; i < prices.length; ++i) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < prices.length; ++i) {
            for (int j = k; j >= 1; --j) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }
    public int maxProfit(int[] prices) {
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            int t = dp_i0;
            // 手里没有股票，可能是前一天也没有，可能是前一天有、今天卖了
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            // 手里有股票，可能是前一天就有，可能是刚买的
            dp_i1 = Math.max(dp_i1, t - prices[i]);
        }
        return dp_i0;
    }
}
