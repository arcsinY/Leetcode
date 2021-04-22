// 状态：dp[i][j]：s的前i个字符和p的前j个字符能否匹配
// 选择：p的第j个字符不是*，则p的第j个字符和s的第i个字符匹配
//      p的第j个字符是*，则p的第j和j-1个字符可以不和s匹配。若p的j-1个字符和s的第i个字符匹配，则这个字符可以和s前面的字符继续匹配
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    // p的第j-1和j个字符不和s匹配
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        // p的第j-1个字符可以继续和前面的匹配
                        dp[i][j] = dp[i][j] || dp[i - 2][j - 1];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    // s的第i个字符能否和p的第j个字符匹配
    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
