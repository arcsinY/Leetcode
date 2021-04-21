// 状态：dp[i][j]：子串s[i]~s[j]之间的最长回文子序列
// 选择：子串两端的字符相等，回文子序列一定是去掉两端字符的回文子序列+2。不相等，可能是i~j-1的，也可能是i+1~j的
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        // base case：一个字符能够组成回文串
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = 1;
        }
        // 因为状态转移方程需要用到i+1和j-1的状态，所以i反向遍历，j正向遍历
        for (int i = s.length() - 1; i >= 0; --i) {
            // i < j
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
