class Solution {
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
