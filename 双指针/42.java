// 位置i能接的雨水量 = i的两侧最大高度的最小值 - height[i]
// 使用left[i]，right[i]表示位置i左侧、右侧的最大高度。从左向右遍历可得到left[i]，从右向左遍历可得到right[i]。空间复杂度O(n)
// 使用双指针对这种方法进行空间上的优化
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            // 左边的最大高度小，计算这个位置的雨水量
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
