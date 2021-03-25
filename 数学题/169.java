// 摩尔投票法，找出出现次数>n/2的元素，时间复杂度O(n)，空间复杂度O(1)
// 设置候选结果和计数器，遍历数组，一个元素!=候选结果时计数器-1，==候选结果时计数器+1
// 计数器==0是更换候选结果为当前元素
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == res) {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    res = nums[i];
                    cnt = 1;
                }
            }
        }
        return res;
    }
}
