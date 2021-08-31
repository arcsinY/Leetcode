// 对nums计算差分数组 arr：arr[i] = nums[i] - nums[i - 1]，arr[0] = nums[0]
// 对差分数组计算前缀和就可以得到原数组
// 当对原数组 [l,r] 区间上的元素增加 inc 时，相当于另 arr[l] += inc, arr[r - 1] -= inc
// 题目编号从1~n，需要向左偏移一位
func corpFlightBookings(bookings [][]int, n int) []int {
    nums := make([]int, n)
    for i := range bookings {
        first := bookings[i][0]
        last := bookings[i][1]
        seat := bookings[i][2]
        nums[first - 1] += seat
        if last < n {
            nums[last] -= seat
        }
    }
    for i := 1; i < n; i++ {
        nums[i] += nums[i - 1]
    }
    return nums
}
