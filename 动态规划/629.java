// 状态：dp[i][j]：1~i的数字排列，恰好有j个逆序对的情况数量
// 选择：从dp[i-1][j]转移到dp[i][j]时新加入的数字可以是1~i之中的任意一个
// 假设新加入的数字是k，首先计算新加入的k与前i-1个数字能组成的逆序对的数量：i-k个
// 要求前i-1个数字能组成j-(i-k)个逆序对，共有dp[i-1][j-(i-k)]种可能
// 状态转移优化：dp[i][j]=dp[i][j-1] - dp[i-1][i-j] + dp[i-1][j]
// 空间优化：两个数组循环使用
class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = (int)1e9 + 7;
        int[] dp = new int[k + 1];
        int[] pre = new int[k + 1];
        dp[0] = 1;
        pre[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                int a = 0, b = 0;
                if (j - 1 >= 0) {
                    a = dp[j - 1];
                }
                if (j - i >= 0) {
                    b = pre[j - i];
                }
                dp[j] = a - b + pre[j];
                if (dp[j] >= MOD) {
                    dp[j] -= MOD;
                } else if (dp[j] < 0) {
                    dp[j] += MOD;
                }
            }
            for (int j = 0; j <= k; ++j) {
                pre[j] = dp[j];
                dp[j] = 0;
            }
            dp[0] = 1;
        }
        return pre[k];
    }
}
