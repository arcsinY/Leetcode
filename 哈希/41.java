// 原地哈希：使用原始数组作为哈希表，避免了额外的空间使用，空间复杂度 O(1)
// 思想：遍历数组，访问到数字 i，则将数组的第 i-1 位置标记为负（为什么是 i-1 位置？因为连续整数的取值为 [1,n]，避免越界）
// 之后再次遍历数组，不为负的位置+1为缺失的正数。若所有位置都是负了，则缺失整数为 n+1
// 如何区分原始负数和标记负数？原始数组中 <=0 的元素修改为 n+1（或更大的），因为不需要对 >=(n+1) 的元素做标记（因为答案最大为 n+1），当所有位置都标记了直接返回 n+1
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 答案取值为 [1, n + 1]
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            // >= n+1 的数字说明之前是负数，或者已经是超过答案的整数了，不用做标记
            if (num < (n + 1)) {
                // 已经标记过的就不用重复标记了  
                if (nums[num - 1] > 0) {
                    nums[num - 1] = -nums[num - 1];
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
