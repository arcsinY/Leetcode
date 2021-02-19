// dp[i]：s中前i个字符组成的字串是否能拆分
// 为了计算dp[i]，遍历i之前的字符串0~j，若0~j可拆分且j+1~i是包含在wordDict中的一个单词，则dp[i]=true
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
