// 状态：dp[i][j][k]：考虑前i个任务，人数不得超过j，盈利不得少于k的可能组合
// 选择：每个任务可以有做和不做两种情况，如果做，则要求这个任务的需要人数 <= 总人数
// basecase：0项任务所需利润为0，有1种选择（什么都不做）
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int mod = (int)1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= n; ++i) {
            dp[0][i][0] = 1;
        }
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= minProfit; ++k) {
                    if (group[i - 1] > j) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        // 如果这一项任务的利润就超过了所需利润，可以做，其它任务所需利润变为0
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % mod;
                    }
                }
            }
        }
        return dp[len][n][minProfit];
    }
}
