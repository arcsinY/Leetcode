import java.util.Arrays;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            return false;
        int m=board.length;int n = board[0].length;
        boolean[][] visit = new boolean[m+2][n+2];
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if (dfs(board, word, m, n, visit, 0, i, j))
                        return true;
                    for(int k=0;k<=m;++k)
                    {
                        Arrays.fill(visit[k],false);
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int m, int n, boolean[][] visit, int start, int row, int col)
    {
        if(start == word.length())
            return true;
        if(row <0 || row>=m || col<0 || col>=n)
            return false;
        if(word.charAt(start) != board[row][col])
            return false;
        if(visit[row][col])
            return false;
        visit[row][col] = true;
        if(dfs(board, word, m,n,visit, start+1,row-1, col))
            return true;
        if(dfs(board, word, m,n,visit, start+1,row+1, col))
            return true;
        if(dfs(board, word, m,n,visit, start+1,row, col-1))
            return true;
        if(dfs(board, word, m,n,visit, start+1,row, col+1))
            return true;
        visit[row][col]=false;
        return false;
    }
}
