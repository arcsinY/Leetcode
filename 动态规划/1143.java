// 状态：dp[i][j]：第一个串的前i个字符和第二个串的前j个字符组成的LCS长度
// 选择：第i个，第j个字符相等，则拼接在前面的LCS后面。若不等，可能是第一个串的前i-1个字符和第二个串的前j个字符组成LCS，或第一个串的前i个字符和第二个串的前j-1个字符组成LCS
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
