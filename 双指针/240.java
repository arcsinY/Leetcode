// 矩阵看作是二叉树，从左下角开始，向上走小于，向右走大于
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = m - 1;
        int right = 0;
        while (up >= 0 && right < n) {
            if (matrix[up][right] == target) {
                return true;
            }
            if (matrix[up][right] > target) {
                up--;
            } else {
                right++;
            }
        }
        return false;
    }
}
