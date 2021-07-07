// 与丑数Ⅱ思路相同，只是3个指针变成了k个指针
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        // k个指针，指向dp数组中的位置
        int[] index = new int[primes.length];
        for (int i = 1; i < n; ++i) {
            int next = Integer.MAX_VALUE;
            // 所有素数与对应的现有丑数相乘，取最小的
            for (int j = 0; j < primes.length; ++j) {
                next = Math.min(dp[index[j]] * primes[j], next);
            }
            dp[i] = next;
            for (int j = 0; j < primes.length; ++j) {
                if (dp[index[j]] * primes[j] == dp[i]) {
                    index[j]++;
                    // 这里不能break，因为其它的dp[index[j]*prime[j]也可能等于dp[i]
                }
            }
        }
        return dp[n - 1];
    }
}
