// 难以判断哪些O是被包围的，因此可以判断哪些O是不被包围的（需要变成X的）
// 从边界的O开始dfs，找到连通的O，标记为A。标记为A的是不需要变化的，没被标记为A的是需要边为X的
// 最后遍历所有位置，所有的A边为O，所有的O边为X
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 从四个边界开始dfs
        // 第一列和最后一列
        for (int i = 0; i < m; ++i) {
            dfs(i, 0, m, n, board);
            dfs(i, n - 1, m, n, board);
        }
        // 第一行和最后一行
        for (int j = 1; j < n - 1; ++j) {
            dfs(0, j, m, n, board);
            dfs(m - 1, j, m, n, board);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    // 从第i行，第j列开始搜索
    void dfs(int i, int j, int m, int n, char[][] board) {
    // 不是O的不需要考虑
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        // 标记为A
        board[i][j] = 'A';
        dfs(i + 1, j, m, n, board);
        dfs(i, j + 1, m, n, board);
        dfs(i - 1, j, m, n, board);
        dfs(i, j - 1, m, n, board);
    }
}
