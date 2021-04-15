// 后一天的更新只与前一天有关，因此更新变量，而不用数组
class Solution {
    public int maxProfit(int[] prices) {
        // 第i天，最多交易过1次，手中没有股票的收益
        int dp_i10 = 0;
        // 第i天，最多交易过2次，手中没有股票的收益
        int dp_i20 = 0;
        // 第i天，最多交易过1次，手中有股票的收益
        int dp_i11 = Integer.MIN_VALUE;
        // 第i天，最多交易过2次，手中有股票的收益
        int dp_i21 = Integer.MIN_VALUE;
        for (int i : prices) {
            // 目前手中没有股票，要么是前一天也没有，今天也没买；要么是前一天有，今天卖了
            dp_i10 = Math.max(dp_i10, dp_i11 + i);
            dp_i20 = Math.max(dp_i20, dp_i21 + i);
            // 手中有股票，要么是前一天手中已经有股票了，今天不卖；要么是刚买的（之前没交易过，收益为0）
            dp_i11 = Math.max(dp_i11, -i);
            // 手中有股票，要么是前一天手中已经有股票了，今天不卖；要么是刚买的（之前可能交易过1次，并且卖了）
            dp_i21 = Math.max(dp_i21, dp_i10 - i);
        }
        return dp_i20;
    }
}
