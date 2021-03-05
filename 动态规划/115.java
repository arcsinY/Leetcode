// dp[i][j]：s的前i个字符和t的前j个字符得到的结果
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {   // 用空串匹配任意字符串，结果为1
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= t.length(); ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // dp[i-1][j-1]：t的最后一个字符匹配s的最后一个字符
                    // dp[i-1][j]：t的所有字符都匹配s的前i-1个字符
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
