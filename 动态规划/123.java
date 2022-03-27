// dp[i][j][0]：第 i 天手里没有股票，之前最多进行过 j 次交易
// dp[i][j][1]：第 i 天手里有股票，之前最多进行过 j 次交易
// 只有买股票时算一次交易
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][1][1] = -prices[0];
        // 进行 0 次交易，手里不可能有股票
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);  // 买股票时将j-1，表示占用一次交易
            }
        }
        return dp[n-1][2][0];
    }
}
