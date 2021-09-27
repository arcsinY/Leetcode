// 状态：dp[i]：前 i 个字符可能的编码数量
// 选择：第 i 个字符可以自己组，也可以和前一个组
// 自己组要求当前字符 != '0'
// 和前一个组要求前一个字符!= '0'且组成的数字 <= 26
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1) {
                int two = Integer.parseInt(s.substring(i - 2, i));
                if (s.charAt(i - 2) != '0' && two <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
