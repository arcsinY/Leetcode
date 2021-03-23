// 峰值前一定是一个递增子数组，之后是一个递减子数组
// 找到mid，若nums[mid]>nums[mid+1]，说明这是递减的子数组，要到mid之前去找峰值（mid也可能是峰值）
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
