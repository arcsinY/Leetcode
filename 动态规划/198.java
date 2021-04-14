// dp[i]：从第i家开始抢得到的收益
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; --i) {
            // 1. 放弃当前房子，从下一家开始抢
            // 2. 抢当前房子，放弃下一家，从下下家开始抢
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
