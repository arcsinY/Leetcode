class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][10];  //row[i][num]表示第i行是否出现过数字num
        boolean[][] col=new boolean[9][10];
        boolean[][][] square=new boolean[3][3][10];   //square[i][i][num]代表第i行的第i个宫格是否出现过num
        for(int i=0;i<9;++i)
        {
            for(int j=0;j<9;++j)
            {
               if(board[i][j] == '.')
                   continue;
               int num=board[i][j]-'0';
               if(row[i][num])
                   return false;
               else
                   row[i][num] = true;
               if(col[j][num])
                   return false;
               else
                   col[j][num]=true;
               if(square[i/3][j/3][num])
                   return false;
               else
                   square[i/3][j/3][num]=true;
            }
        }
        return true;
    }
}