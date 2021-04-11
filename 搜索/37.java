// 在原地修改数组，递归出口时不需要添加路径，但找到一个结果后要直接返回，不能继续回溯
class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    // 对第row行，第col列的位置填入数字
    public boolean dfs(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return dfs(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return dfs(board, row, col + 1);
        }
        // 尝试1-9
        for (char i = '1'; i <= '9'; ++i) {
            if (check(board, row, col, i)) {
                board[row][col] = i;
                if (dfs(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    // 判断是否能填入c
    public boolean check(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
            // (row/3)*3, (col/3)*3是所在宫格的第一个位置，
            if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == c) {
                return false;
            }
        }
        return true;
    }
}
