// 从所有的1开始dfs，遍历到的地方改为0，避免额外使用vis记录
// 一次dfs的结果是一个岛屿
class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    ++ans;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : dir) {
            dfs(grid, i  + d[0], j + d[1], m, n);
        }
    }
}
