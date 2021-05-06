// 上一次跳跃后，能够达到的最远位置为end（初始为0）
// 目前能够跳跃到的最远位置为maxPos（初始为0）
// 当i == end时，需要进行一次跳跃才能达到end之后的位置
class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int end = 0;
        int maxPos = 0;
        // 由于一定能达到最后位置，不需要考虑nums.length。否则当end == nums.length时，会进行一次额外的跳跃
        for (int i = 0; i < nums.length - 1; ++i) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                ++res;
            }
        }
        return res;
    }
}
