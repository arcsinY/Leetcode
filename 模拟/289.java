// 对于状态改变的细胞，要记录他们上一次的状态。但又不能使用额外空间，因此使用额外状态标记这些细胞
// 上次活的现在死了——状态2
// 上次死的现在活了——状态3
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] neighbor = new int[]{0,1,-1};   // 用于遍历8个格
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                int cnt = 0;   // 记录周围细胞中活的数量（上一轮活的）
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        if (neighbor[i] == 0 && neighbor[j] == 0) {   // 还在自己的位置
                            continue;
                        }
                        // 先改变位置，再判断是否合法
                        int r = row + neighbor[i];
                        int c = col + neighbor[j];
                        // 判断位置合法
                        if (r < m && r >=0 && c < n && c >= 0 && (board[r][c] == 1 || board[r][c] == 2)) {
                            ++cnt;
                        }
                    }
                }
                if (board[row][col] == 1 && (cnt < 2 || cnt > 3)) {
                    board[row][col] = 2;
                }
                if (board[row][col] == 0 && cnt == 3) {
                    board[row][col] = 3;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
