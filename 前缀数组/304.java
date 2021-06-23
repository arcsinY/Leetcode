// 二维数组前缀和：sum[i][j]:从matrix[0][0]~matrix[i - 1][j - 1]的所有元素和
// sum[i][j]可根据当前位置元素和左边sum、上边sum、坐上sum计算
// 一个区域元素和可根据四个角的sum计算
class NumMatrix {
    int m, n;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
