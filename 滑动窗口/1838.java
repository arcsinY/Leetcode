// 观察1：最终频率最高的数一定是数组中元素
// 观察2：先让距离进的数变为频率最高的数
// 因此可以枚举数组中每个元素，按顺序访问比他小的数，计算k步之内能将多少个数变为这个数
// 可以利用上一次循环的中间结果。当最终最高频率的数从nums[i]变为nums[i+1]后，相比上一次，num[i]会执行(nums[i+1] - nums[i])次+1操作，
// nums[i]前面的数会先变到nums[i]，再执行(nums[i+1] - nums[i])次+1操作。因此总+1次数相比上一次多了(nums[i] - nums[i - 1]) * (i - left)，其中left是左边界
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long need = 0;
        for (int i = 1; i < nums.length; ++i) {
            need += (long)(nums[i] - nums[i - 1]) * (i - left);
            while (need > k) {
                need -= nums[i] - nums[left];
                ++left;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
