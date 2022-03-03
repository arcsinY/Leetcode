// 先二分找到满足 matrix[i][0] < target 的最后一行，之后在这一行里二分
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left < right) {
            // 不 +1 会死循环
            int mid = (left + right + 1) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int left2 = 0, right2 = n - 1;
        while (left2 <= right2) {
            int mid = left2 + (right2 - left2) / 2;
            if (matrix[left][mid] == target) {
                return true;
            } else if (matrix[left][mid] > target) {
                right2 = mid - 1;
            } else {
                left2 = mid + 1;
            }
        }
        return false;
    }
}
