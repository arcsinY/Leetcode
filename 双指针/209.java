// 维护两个指针之间的子数组和，若大于等于target，更新res，左指针左移，减小子数组和
// 若小于target，右指针右移，增大子数组和
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = nums[0];
        int res = 0;
        while (left < nums.length && right < nums.length) {
            if (sum >= target) {
                if (res == 0) {
                    res = right - left + 1;
                } else {
                    res = Math.min(res, right - left + 1);
                }
                sum -= nums[left];
                ++left;
            }
            if (sum < target) {
                if (right < nums.length) {
                    ++right;
                    if (right < nums.length) {
                        sum += nums[right];
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
