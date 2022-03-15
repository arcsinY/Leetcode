func generateParenthesis(n int) []string {
    ans := make([]string, 0)
    var one string
    dfs(&ans, &one, 0, 0, n)
    return ans
}

func dfs(ans *[]string, one *string, left int, right int, n int) {
    if len(*one) == 2 * n {
        *ans = append(*ans, *one)
        return
    }
    // 左括号还没满，可以插入左括号
    if left < n {
        *one += "("
        dfs(ans, one, left + 1, right, n)
        *one = (*one)[:len(*one) - 1]
    }
    // 只有右括号数量小于左括号时，才能插入右括号，否则一定不合法
    if right < left {
        *one += ")"
        dfs(ans, one, left, right + 1, n)
        *one = (*one)[:len(*one) - 1]
    }
}
