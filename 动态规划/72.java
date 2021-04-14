// dp[i][j]:word1的前i个字符和word2的前j个字符的编辑距离
// 因为base case是某一个字符串0个字符时（数组下标为-1），编辑距离=另一字符串长度。因此不能另dp[i][j]代表word1[i]到word2[j]的编辑距离，dp中要多留一个位置
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 当前位置字符相同，不用处理
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 三种替换方式都选择一遍：
                    // 1. 在word2中插入word1[i]的元素，之后向前移动两个指针，word2由于多了一个字符，指针仍为j，word1的指针变为i-1
                    // 2. 在word2中删除当前元素
                    // 3. 替换
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
