// 问题转化：是否能选出某几个元素，凑出sum/2。sum是数组和。变为0-1背包问题
// 特殊情况：sum不是偶数，一定不行。数组长度== 1，一定不行。最大元素 > sum / 2，说明其它元素和 < sum / 2，一定不行。
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int max = -1;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        if (max > sum) {
            return false;
        }
        // 0-1背包问题的空间优化
        boolean[] dp = new boolean[sum + 1];
        dp[nums[0]] = true;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = sum; j >= 0; --j) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
