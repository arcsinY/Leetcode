// 由于有相等元素，不能根据nums[mid], nums[mid-1], numd[mid+1]判断nums[mid]是不是最小值
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 最小值在右半部分，且nums[mid]不可能是最小值 
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            // 查找左半部分，mid可能是最小值，因此不能另right = mid - 1
            } else if (nums[mid] < nums[right]) {
                right = mid;
            // nums[mid] == nums[right]，不能判断哪边有最小值。由于right与mid相等，不需考虑right，范围减小1
            } else {
                --right;
            }
        }
        return nums[left];
    }
}
