// dp[i]：最后抢第i家的最大收益
// 最终结果要返回dp中最大的
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i - 1; ++j) {
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + nums[i];
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
