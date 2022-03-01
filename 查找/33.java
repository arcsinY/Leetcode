// 将数组分为两部分：[left, mid] 和 [mid + 1, right]，一定有其中一部分是有序的
// 借助有序的这部分判断是否需要在有序的这部分上搜索
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return  -1;
        }
        int low = 0;
        int high = nums.length-1;
        int mid;
        // [low, high] 区间上搜索
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[0] <= nums[mid]) {
                // mid 在交换位置之前，mid 左侧的都比 nums[mid] 小，但大于 nums[0]
                if(nums[0] <= target && target < nums[mid]) {  // 在左侧寻找
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                // mid 在交换位置之后，mid 右侧的数有序，都大于 nums[mid] 但小于 nums[nums.length - 1]
                if(nums[mid] < target && target <= nums[nums.length-1]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
