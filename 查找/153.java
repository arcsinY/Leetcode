// 使用二分查找寻找换位点，最小元素一定在换位点处
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        if (nums[right] > nums[left]) {
            return nums[0];
        }
        while (left <= right) {
            mid = (left + right) / 2;
            // 换位点
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // 右边有序，在左侧找换位点
            if (nums[right] > nums[mid]) {
                right = mid - 1;
            }
            // 左边有序，在右侧找换位点
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
