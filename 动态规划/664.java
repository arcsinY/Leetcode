// 状态：dp[i][j]：产生s[i]~s[j]的打印次数
// 选择：s[i] == s[j]时，因为s[i]一定可以跟着s[j]一起打印出来，考虑s[j]，相当于打印s[i]~s[j-1]就行
// s[i] != s[j]时，分别打印s[i]~s[k]和s[k+1]~s[j]两部分
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j <n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = i; k < j; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
