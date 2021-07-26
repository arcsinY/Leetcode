// 因为要子序列最长，子序列的增加过程越慢越好
// ans[i]：长度为i的最长递增子序列最后一位数字。ans一定是递增的，因此可以使用二分搜索
// 遍历nums，若nums[j] > ans中的最后一个数字，则加入ans末尾，意思是在长度为len - 1的子序列上加了一个数字，得到长度为len的子序列
// 否则找出当前ans中的位置i，满足ans[i-1] < nums[j] < ans[i]，用nums[j]替换ans[i]。意思是在长度为i - 1的子序列后面加上一个更小的数字，得到长度为i的子序列
func lengthOfLIS(nums []int) int {
	ans := make([]int, len(nums) + 1)
	index := 1
	ans[index] = nums[0]
	for i := range nums {
		if nums[i] > ans[index] {
			ans[index + 1] = nums[i]
			index++
		} else {
			t := binarySearch(ans, nums[i], index)
			ans[t] = nums[i]
		}
	}
	return index
}

// 在ans中寻找 < target的最大位置i，因为要修改的是ans[i - 1]，因此返回i-1
func binarySearch(ans []int, target int, index int) int {
	low := 1
	high := index
	for low <= high {
		mid := low + (high - low) / 2
		if ans[mid] < target {
			low = mid + 1
		} else if ans[mid] == target{
			return mid
		} else {
			high = mid - 1
		}
	}
	return high + 1
}
