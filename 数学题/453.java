// n - 1个数字 +1，相当于1个数字 -1
// 因此考虑将所有数都减小到最小的数字，需要几次操作
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        int ans = 0;
        for (int i : nums) {
            ans += i - min;
        }
        return ans;
    }
}
