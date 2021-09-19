// 状态：dp[i]：得到 i 个A需要操作的次数
// 转移：对于能将 i 整除的数 j ，可以在得到 j 个字符时复制一次，之后粘贴 (i/j - 1) 次
// 优化：i 必然有两个因数 j 和 i/j，两个数中必然有一个小于 i，因此每次只需遍历 0-sqrt(i)，每次转移两个状态
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
