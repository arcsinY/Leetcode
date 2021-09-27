// 状态：dp[i]：前i个字符可能的编码数量
// 选择：1. 当前字符自己编码
//        （1）当前字符是'*'，有9种可能
//        （2）当前字符是1~9，有1种可能
//        （3）当前字符是0，不可能
//      2. 当前字符与前一个字符共同编码
//        （1）两个字符都是'*'，可以组成11~19，21~26共15种可能
//        （2）只有前一个字符是'*'，若当前字符是1~6，前一个字符可以取1或2，2种情况
//        （3）只有当前字符是'*'，前一个字符是1，可以组成11~19，9种可能。前一个字符是2，可以组成21~26，6种可能。前一个字符 > 2，不可能
//        （4）两个字符都是数字，要求前一个字符不为0且组成的数字 <= 26
class Solution {
    final int mod = (int)1e9 + 7;
    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] += (dp[i - 1] * case1(s.charAt(i - 1)));
            dp[i] %= mod;
            if (i > 1) {
                dp[i] += (dp[i - 2] * case2(s.charAt(i - 1), s.charAt(i - 2)));
                dp[i] %= mod;
            }
        }
        return (int)dp[n];
    }
    public int case1(char cur) {
        if (cur == '*') {
            return 9;
        }
        if (cur == '0') {
            return 0;
        } else {
            return 1;
        }
    }
    public int case2(char cur, char pre) {
        if (cur == '*' && pre == '*') {
            return 15;
        }
        if (pre == '*') {
            if (cur <= '6') {
                return 2;
            }
            return 1;
        }
        if (cur == '*') {
            if (pre == '1') {
                return 9;
            }
            if (pre == '2') {
                return 6;
            }
            return 0;
        }
        if (pre != '0' && ((pre - '0') * 10 + cur - '0' <= 26)) {
            return 1;
        }
        return 0;
    }
}
