// 与丑数Ⅱ思路相同，只是3个指针变成了k个指针
func nthSuperUglyNumber(n int, primes []int) int {
    m := len(primes)
    dp := make([]int, n)
    dp[0] = 1
    index := make([]int, m)
    for i := 1; i < n; i++ {
        dp[i] = 2147483647
        for j := 0; j < m; j++ {
            dp[i] = min(dp[index[j]] * primes[j], dp[i])
        }
        for j := 0; j < m; j++ {
            if dp[i] == dp[index[j]] * primes[j] {
                index[j]++
            }
        }
    }
    return dp[n - 1]
}

func min(a, b int) int {
    if (a <= b) {
        return a
    }
    return b
}
