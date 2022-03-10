// 下一个排列的规则：
// 1. 右边的一个大数与左边一个小数交换位置
// 2. 右边的大数尽可能靠右
// 3. 交换后大数后面的数字升序排列
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1, k = nums.length - 1;
        // 从右开始找出第一个 nums[i] < nums[i+1] 的位置
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        // 找右侧的大数
        if (i >= 0) {
            while (nums[k] <= nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }
        // 交换之后 j 右侧的数字降序排列，直接反转变成升序
        k = nums.length - 1;
        reverse(nums, i, k);
    }
    public void swap(int[] nums, int i, int k) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
