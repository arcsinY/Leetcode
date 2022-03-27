class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][k + 1][2];
        // 第 0 天买股票，收益为 -prices[0]
        for (int i = 1; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        // 第 0 天买股票，但交易次数为0，非法状态
        dp[0][0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
