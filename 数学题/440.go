// 以 x 位前缀，小于 n 的数字有 cnt 个
// 如果 cnt < k，则将前缀 x + 1，还需寻找 k - cnt 个数字
// 如果 cnt >= k，则将前缀补一个 0，k - 1 表示跳过 x 本身
func findKthNumber(n int, k int) int {
    ans := 1
    for k != 1 {
        cnt := count(ans, n)
        if cnt < k {
            ans++
            k -= cnt
        } else {
            k--
            ans *= 10
        }
    }
    return ans
}

// 以 x 为前缀的数字中，<= limit 的个数
func count(x int, limit int) int {
    // x 为 n 位整数，limit 为 m 位整数
    a := strconv.Itoa(x)
    b := strconv.Itoa(limit)
    n, m := len(a), len(b)
    k := m - n
    ans := 0
    // n 位整数中，只有 x 一个
    // n + 1 < m 位整数中，有 x0~x9 共10个
    // n + 2 < m 位整数中，有 100 个
    // ......
    for i := 0; i < k; i++ {
        ans += int(math.Pow(10, float64(i)))
    }
    // 计算 m 位整数中有多少个 <= limit 的数字
    // 先提取 x 的前 n 位和 limit 的前 n 位作比较
    prefix := b[:n]
    prefixNum, _ := strconv.Atoi(prefix)
    if prefixNum == x {
        // 例：x = 123，limit = 12345，则 5 位数中有 12300~12345 共46个数字符合要求
        ans += limit - x * int(math.Pow(10, float64(k))) + 1
    } else if prefixNum > x {
        // 例：x = 123，limit = 12445，所有 123xx 的 5 位数都符合要求
        ans += int(math.Pow(10, float64(k)))
    }
    return ans
}
