class Solution {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        // int[][] board = new int[n][n];
        int[] row = new int[n];   // 第i行的皇后放在了第几列
        boolean[] col = new boolean[n];  // 第i列有无皇后
        return dfs(n, 0, row, col);
    }
    // 当前放置第now行
    public int dfs(int n, int now, int[] row, boolean[] col) {
        if (now == n) {
            return 1;
        }
        int res = 0;
        // 在0~(n-1)列尝试放置
        for (int i = 0; i < n; ++i) {
            if (col[i] == true) {   // 这一列已经有了
                continue;
            }
            int j = 0;
            // 判断对角线，行的差 == 列的差，说明在同一对角线
            for (j = 0; j < now; ++j) {
                if (Math.abs(row[j] - i) == Math.abs(j - now)) {
                    break;
                }
            }
            if (j < now) {
                continue;
            }
            // 放置
            row[now] = i;
            col[i] = true;  //记录这一列已经有了
            res += dfs(n, now+1, row, col);   //递归
            col[i] = false;   //回溯，要变化列，要让这一列没有
        }
        return res;
    }
}
