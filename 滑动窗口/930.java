// 滑动窗口左侧有两个边界，left1和left2。在[left1,left2)中的元素都能和right - 1组成子数组
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;
        while(right < nums.length) {
            sum1 += nums[right];
            sum2 += nums[right];
            right++;
            while (sum1 > goal && left1 < right) {
                sum1 -= nums[left1];
                ++left1;
            }
            while (sum2 >= goal && left2 < right) {
                sum2 -= nums[left2];
                ++left2;
            }
            ans += left2 - left1;
        }
        return ans;
    }
}
