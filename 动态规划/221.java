// dp[i][j]：以(i,j)为右下角的正方形边长。
// 若matrix[i][j]==1，则dp[i][j] = min{dp[i-1][j], dp[i][j-1],dp[i-1][j-1]} + 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1; 
                    }
                    if (dp[i][j] > res) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res * res;
    }
}
