// 交换点（交换位置右边的点）为最小元素
// 情况1：在交换点一侧的子数组，子数组最左元素 < 子数组最右元素
// 情况2：跨越交换点的子数组，子数组最左元素 > 子数组最右元素
func findMin(nums []int) int {
    left := 0
    right := len(nums) - 1
    for left < right {
        mid := left + (right - left) / 2
        // 情况1：mid在交换点右侧，之后到左侧寻找（包含mid）
        if nums[mid] < nums[right] {
            right = mid
        } else {
            // 请款2：交换点在mid右侧，之后在右侧寻找（不包含mid）
            left = mid + 1
        }
    }
    return nums[left]
}
