// 第 i 和第 j 位置上数据的相乘结果存在 ans[i + j + 1] 上，有进位将进位存在 ans[i + j] 上
func multiply(num1 string, num2 string) string {
    if num1 == "0" || num2 == "0" {
        return "0"
    }
    n := len(num1)
    m := len(num2)
    ans := make([]int, m + n)
    for i := n - 1; i >= 0; i-- {
        t1 := int(num1[i]) - '0'
        for j := m - 1; j >= 0; j-- {
            t2 := int(num2[j] - '0')
            ans[i + j + 1] += t1 * t2
        }
    }
    for i := m + n - 1; i > 0; i-- {
        ans[i - 1] += ans[i] / 10;
        ans[i] %= 10;
    }
    ret := strings.Builder{}
    idx := 0
    if ans[0] == 0 {
        idx = 1
    }
    for ; idx < m + n; idx++ {
        ret.WriteString(strconv.Itoa(ans[idx]))
    }
    return ret.String()
}
