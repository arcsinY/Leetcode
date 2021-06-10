// 状态：dp[i][j]：前i个零钱，凑出j元的组合数量
// 选择：每个硬币可以不选，或选1~j/coins[i]个
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= amount; ++i) {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                // k == 0时相当于不选这个硬币
                for (int k = 0; k <= j / coins[i - 1]; ++k) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
