// 最后一间房子和第一间房子只能二选一（或者都不选，但选择范围小了，这种情况下的解一定包含在另两种情况中）
// 按照原始问题的方法计算两次，一次从倒数第二间开始，计算到第一间。一次从最后一间到第二间，结果取最大值
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 2];
        int[] dp2 = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 1; --i) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        for (int i = nums.length - 2; i >= 0; --i) {
            dp2[i] = Math.max(dp2[i + 1], nums[i] + dp2[i + 2]);
        }
        return Math.max(dp[1], dp2[0]);
    }
}
