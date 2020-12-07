class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int t = 1;
        int left=0,right=n-1,top = 0,bottom = n-1;
        while(left<=right && top <= bottom)
        {
            for(int i=left;i<=right;++i)
                res[top][i] = t++;
            for(int i=top+1;i<=bottom;++i)
                res[i][right]=t++;
            if(left<right && bottom > top){
            for(int i=right-1;i>left;--i)
                res[bottom][i] = t++;
            for(int i=bottom;i>top;--i)
                res[i][left]=t++;
            }
            ++left;
            --right;
            --bottom;
            ++top;
        }
        return res;
    }
}