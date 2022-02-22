// 移动之后，后 move 个元素变到数组头部 move 个位置，前 n-move 在后 n-move 个位置上
// 先将数组反转，再将前 move 个和后 n-move 个反转
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int move = k % n;
        if (move == 0 || n == 1) {
            return;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, move);
        reverse(nums, move + 1, n - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            ++start;
            --end;
        }
    }
}
