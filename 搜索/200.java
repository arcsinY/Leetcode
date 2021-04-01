// 从所有的1开始dfs，用vis记录遍历过的1
// 一次dfs的结果是一个岛屿
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (vis[i][j] || grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j, vis, m, n);
                ++res;
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j, boolean[][] vis, int m, int n) {
        // 遍历到搜索过的，或0则停止
        if (vis[i][j] == true || grid[i][j] == '0') {
            return;
        }
        vis[i][j] = true;
        if (i != 0) {
            dfs(grid, i - 1, j, vis, m, n);
        }
        if (i != m - 1) {
            dfs(grid, i + 1, j, vis, m, n);
        }
        if (j != 0) {
            dfs(grid, i, j - 1, vis, m, n);
        }
        if (j != n - 1) {
            dfs(grid, i, j + 1, vis, m, n);
        }
    }
}
