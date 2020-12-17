class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(matrix == null || m == 0)
            return;
        int n = matrix[0].length;
        if(n == 0)
            return;
        boolean col = false;  //第一列是否为0
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(matrix[i][j] == 0)
                {
                    if(j == 0)  //matrix[0][0]只表示第一行，要用额外变量表示第一列第一列为0
                    {
                        col = true;
                        continue;
                    }
                    matrix[i][0] = 0;   // 用这一行/列的第一个标记这一行/列是否为0
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;++i)  //除第一列和第一行之外的
        {
            for(int j=1;j<n;++j)
            {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j]=0;
            }
        }
        if(matrix[0][0] == 0)   //第一行
        {
            for(int i=0;i<n;++i)
                matrix[0][i]=0;
        }
        if(col)   //第一列
        {
            for(int i=0;i<m;++i)
                matrix[i][0] = 0;
        }
    }
}