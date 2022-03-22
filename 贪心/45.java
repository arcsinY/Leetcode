// 上一次跳跃后，能够达到的最远位置为 end（初始为 0）
// 目前能够跳跃到的最远位置为 maxPos（初始为 0）
// 当 i == end 时，需要进行一次跳跃才能达到end之后的位置
class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int maxPos = 0;
        // 由于一定能达到最后位置，不需要考虑 nums.length。否则当 end == nums.length 时，会进行一次额外的跳跃
        for (int i = 0; i < nums.length - 1; ++i) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}
