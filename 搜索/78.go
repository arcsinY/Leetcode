func subsets(nums []int) [][]int {
    ans := make([][]int, 0)
    one := make([]int, 0)
    dfs(nums, 0, &ans, &one)
    return ans
}

func dfs(nums []int, start int, ans *[][]int, one *[]int) {
    t := make([]int, len(*one))
    copy(t, *one)
    *ans = append(*ans, t)
    for i := start; i < len(nums); i++ {
        *one = append(*one, nums[i])
        dfs(nums, i + 1, ans, one)
        *one = (*one)[:len(*one) - 1]
    }
}
