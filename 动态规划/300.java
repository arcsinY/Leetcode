// 状态：dp[i]：以i为结尾得最长上升子序列
// 选择：第i个数字可以拼接在前面任何一个子序列之后
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
