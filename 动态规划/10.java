// 状态：dp[i][j]：s 的前 i 个字符和 p 的前 j 个字符能否匹配
// 选择：
// (1) p 的第 j 个字符不是 * ，则 p 的第 j 个字符必须和 s 的第 i 个字符匹配
// (2) p 的第 j 个字符是 * ，则：
//     (2-1) p 的第 j-1 个字符不和 s 的第 i 个字符匹配，直接忽略 p 的第 j 和 j-1 个字符
//     (2-2) p 的第 j-1 个字符和 s 的第 i 个字符匹配，则可以和 s 前面的字符继续匹配，或者忽略掉 p 的第 j-1, j 两个个字符
public class Solution {
    public boolean match (String str, String pattern) {
        int m = str.length();
        int n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    if (chMatch(str, pattern, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (chMatch(str, pattern, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean chMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            return true;
        }
        return false;
    }
}
