class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1, left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    ans[bottom][i] = num++;
                }
                for (int i = bottom; i > top; i--) {
                    ans[i][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
