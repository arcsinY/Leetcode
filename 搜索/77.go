func combine(n int, k int) [][]int {
    ans := make([][]int, 0)
    one := make([]int, 0)
    dfs(n, k, 1, &one, &ans)
    return ans
}

func dfs(n int, k int, start int, one *[]int, ans *[][]int) {
    if len(*one) == k {
        t := make([]int, len(*one))
        copy(t, *one)
        *ans = append(*ans, t)
    }
    for i := start; i <= n; i++ {
        *one = append(*one, i)
        dfs(n, k, i + 1, one, ans)
        *one = (*one)[:len(*one) - 1]
    }
}
