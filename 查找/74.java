import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0 || matrix == null)
            return false;
        int n = matrix[0].length;
        if(n == 0)
            return false;
        for(int i=0;i<m;++i)
        {
            if(target >= matrix[i][0] && target <= matrix[i][n-1])
            {
                if(target == matrix[i][0] || target == matrix[i][n-1])
                    return true;
                int res = Arrays.binarySearch(matrix[i], target);
                if(res<0)
                    return false;
                else
                    return true;
            }
            if(i != m-1)
            {
                if(target>matrix[i][n-1] && target<matrix[i+1][0])
                    return false;
            }

        }
        return false;
    }
}