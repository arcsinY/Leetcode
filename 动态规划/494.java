// 状态：dp[i][j]：前 i 个数，凑出 j 的可能情况
// 要求数组的第二维下标一定 >= 0，因此第二维要加上一个偏移，使得数组中的任意组合都 >= 0，偏移量sum为数组元素的绝对值之和，因为数组能凑成的数不可能比sum的绝对值还小
// 选择：当前一个数有加和减两种可能
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += Math.abs(i);
        }
        if (sum < target) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];   // 第二维的下标从 -sum~sum
        dp[0][0 + sum] = 1;   // base case，用前0个数凑成0
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = -sum; j <= sum; ++j) {
                if (j + sum - nums[i - 1] >= 0) {  // 情况一：加上这个元素。这个元素本身 <= j+sum 才可能加上，相当于当前物品容量 <= 剩余容量
                    dp[i][j + sum] += dp[i - 1][j + sum - nums[i - 1]];
                }
                if (j + sum + nums[i - 1]  <= sum * 2) {   // 情况二：减去这个元素
                    dp[i][j + sum] += dp[i - 1][j + sum + nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target + sum];
    }
}
