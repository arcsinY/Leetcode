// 相比于无限次交易的问题，增加了手续费。只需在买股票时的成本上加上手续费
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            int t = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, t - prices[i] - fee);
        }
        return dp_i0;
    }
}
