// 状态：dp[i]：组成i需要多少个完全平方数
// 选择：每次可以选择一个 <= i的完全平方数，作为组合中的一个
class Solution {
    public int numSquares(int n) {
        int len = (int)Math.sqrt(n) + 1;
        int[] square = new int[len + 1];
        // 先找到所有 < n的完全平方数
        for (int i = 1; i <= len; ++i) {
            square[i] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= len && square[j] <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - square[j]] + 1);
            }
        }
        return dp[n];
    }
}
