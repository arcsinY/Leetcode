// 贪心：尽可能选择最小元素作为三元组中的前两个元素
// min记录三元组中最小的元素，mid记录中间元素
// 遇到比min更小的元素时，直接更新min，因为虽然min在mid之后出现，但已经保证有 < mid的数在mid之前了，这样可以后面正确更新mid
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > mid) {
                return true;
            } else if (nums[i] > min && nums[i] <= mid) {
                mid = nums[i];
            } else {
                min = nums[i];
            }
        }
        return false;
    }
}
