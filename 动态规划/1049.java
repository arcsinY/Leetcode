// 两块石头重量分别为a，b（a >= b），粉碎后的重量为a-b。a-b再次放入石堆，做被减数时仍为a-b，做减数时变为 b-a，因此每个石头重量前面的符号都可能是 + 或 -
// 问题转化为：为每个数字前面添加正负号，使得计算结果的绝对值最小
// 问题转化为：数组分为两堆，两堆的差最小
// 问题转化为：找出一堆数字，使得其和是不超过sum / 2的最大值。即01背包问题
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int t = sum / 2;
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= t; ++j) {
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return Math.abs(sum - 2 * dp[n][t]);
    }
}
