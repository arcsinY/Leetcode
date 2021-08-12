// 状态：dp[i][j]：子串s[i]~s[j]之间的最长回文子序列
// 选择：子序列两端的字符相等，回文子序列一定是去掉两端字符的回文子序列+2。不相等，可能是 i ~ j-1 的，也可能是 i + 1~j 的
func longestPalindromeSubseq(s string) int {
	n := len(s)
	dp := make([][]int, n)
	for i := range s {
		dp[i] = make([]int, n)
		dp[i][i] = 1
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			if s[i] == s[j] {
				dp[i][j] = dp[i + 1][j - 1] + 2
			} else {
				dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
			}
		}
	}
	return dp[0][n - 1]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
