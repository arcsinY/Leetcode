class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];  //dp[i][j]:走到(i,j)位置有多少种方法
        dp[0][0] = obstacleGrid[0][0] == 0?1:0;
        for(int i=1;i<m;++i)   //第一列的初始值
        {
            if(obstacleGrid[i][0] == 0 && dp[i-1][0]==1)   //无障碍物，且上面的一格能走通
                dp[i][0]=1;
            else
                dp[i][0]=0;
        }
        for(int i=1;i<n;++i)
        {
            if(obstacleGrid[0][i] == 0 && dp[0][i-1] == 1)  //无障碍物，且左面的一格能走通
                dp[0][i]=1;
            else
                dp[0][i]=0;
        }
        for(int i=1;i<m;++i)
        {
            for(int j=1;j<n;++j)
            {
                if(obstacleGrid[i][j] == 1)
                    dp[i][j]=0;
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}