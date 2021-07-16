class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a = left(nums, target);
        int b = right(nums, target);
        return new int[]{a, b};
    }
    // 查找区间：左闭右开
    public int left(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] == target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low == nums.length || nums[low] != target) {
            return -1;
        }
        return low;
    }
    public int right(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] == target) {
                low = mid + 1;
            } else {
                low = mid + 1;
            }
        }
        if (low == 0 || nums[low - 1] != target) {
            return -1;
        }
        return low - 1;
    }
}
