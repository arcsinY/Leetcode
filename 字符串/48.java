class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0)
            return;
        int n = matrix.length;   //n*n矩阵
        for(int i=0;i<n;++i)   //先转置
        {
            for(int j=i+1;j<n;++j)
            {
                int t = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        for(int i=0;i<n;++i)   //每一行颠倒
        {
            int j=0,k=n-1;
            while(j<k)
            {
                int t = matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=t;
                j++;k--;
            }
        }
    }
}