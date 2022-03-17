// dp[i]：以s[i]为结尾的最长括号子串
// 遍历到i时，考虑s[i-1]和s[i]两个字符，只有s[i]==')'时才可能出现以s[i]为结尾的括号串
// 因此有两种情况：s[i-1]=='(', s[i-1]==s[i]==')'
// 对于第一种情况，相比于s[i-2]为结尾的最长括号串多了一对括号，因此dp[i]=dp[i-2]+1
// 对于第二种情况，寻找以i-1为结尾的最长括号串的前一个字符，若为'('，说明相比于以i-1为结尾的最长括号串多了一对括号，同时要加上更之前的最长括号串
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')' && s.charAt(i-1) == '(') {
                if (i >= 2) {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    dp[i] = 2;
                }
            } else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')' && (i-dp[i-1]-1) >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                // i-dp[i-1]-1 是以 i-1 为结尾的最长括号串的第一个位置
                if ((i-dp[i-1]-2) >= 0) {
                    // dp[i - dp[i - 1] - 2] 是更之前的一个括号串的长度
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                } else {
                    dp[i] = dp[i - 1] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
