// dp[i][j]：以(i,j)为右下角的最大正方形边长
// 若matrix[i][j] == 1，则状态转移：dp[i][j] = min{dp[i-1][j-1], dp[i][j-1], dp[i-1][j]} + 1
// 若以(i,j)为右下角的最大正方形边长为x，则其中包含边长为(x-1),(x-2),...,1的正方形，都要加在结果中
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                res += dp[i][j];  // 加上其包含的所有正方形
            }
        }
        return res;
    }
}
