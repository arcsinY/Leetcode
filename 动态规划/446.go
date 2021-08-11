// 状态：dp[i][j]：以 nums[i] 为结尾的，差为 j 的等差子序列数量。由于差的范围太大，因此第二维使用哈希表，key为差，val为数量
// 选择：每个 nums[i] 都尝试和前面的所有 nums[j] 组成等差子序列。即 nums[i] 接在 nums[j] 后面
func numberOfArithmeticSlices(nums []int) int {
	n := len(nums)
	if n < 3 {
		return 0
	}
	ans := 0
	dp := make([]map[int]int, n)
	for i := range nums {
		dp[i] = map[int]int{}
		for j := 0; j < i; j++ {
			d := nums[i] - nums[j]
			dp[i][d] += dp[j][d] + 1
		}
	}
	for i := range dp {
		for j := range dp[i] {
			ans += dp[i][j]
		}
	}
  // 在所有结果中，去掉长度为2的子序列。所有(nums[i],nums[j])都会组成一个长度为2的等差子序列，因此减去所有的两两组合
	ans -= n * (n - 1) / 2
	return ans
}
