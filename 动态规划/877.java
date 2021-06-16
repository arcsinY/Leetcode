// dp[i][j]：目前剩余piles[i]~piles[j]的石子，两者目前拥有石子数量之差
// 当前状态 = 当前拿走石子数量 - 下一个状态的值。当前可以拿走piles[i]或piles[j]个石子
// base case：i == j，只有一行的石子，直接拿走，差为piles[i]
// 空间优化，因为i是递减的，且dp[i]只与dp[i+1]有关，因此可以省略dp数组的第一维
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = piles[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] > 0;
    }
}
