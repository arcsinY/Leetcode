// 状态：dp[i]：凑出i元钱所需的最少硬币
// 选择：每个硬币有用和不用两种情况
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;    // 凑0元，不需要钱币
        for (int i = 0; i <= amount; ++i) {
            for (int j = 0; j < n; ++j) {
                if (coins[j] <= i) {   // 用coins[j]，还需凑出i - coins[j]
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return dp[amount];
    }
}
