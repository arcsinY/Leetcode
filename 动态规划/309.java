class Solution {
    public int maxProfit(int[] prices) {
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        int dp_pre0 = 0;   // 前天，手中没有股票，的收益
        for (int i = 0; i < prices.length; ++i) {
            int t = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            // 前天没股票，今天买的
            dp_i1 = Math.max(dp_i1, dp_pre0 - prices[i]);
            dp_pre0 = t;
        }
        return dp_i0;
    }
}
