// 如果nums[i]<0，需要找以nums[i-1]为结尾的最小乘积与nums[i]相乘，因此要记录一个min
// dpMax[i]：以nums[i]为结尾的最大乘积
// dpMin[i]：以nums[i]为结尾的最小乘积
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int preMax = nums[0], preMin = nums[0];
        int nowMax = preMax, nowMin = preMax;
        for (int i = 1; i < nums.length; ++i) {
            nowMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            nowMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            preMax = nowMax;
            preMin = nowMin;
            if (Math.max(nowMax, nowMin) > res) {
                res = Math.max(nowMax, nowMin);
            }
        }
        return res;
    }
}
