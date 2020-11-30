import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0)
            return new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<>(matrix.length*matrix[0].length);
        int row = matrix.length;
        int col = matrix[0].length;
        int left=0,right=col-1,top=0,bottom=row-1;
        while(left<=right && top <= bottom)   //逐圈遍历
        {
            for(int i=left;i<=right;++i)   //最上一行完全遍历
                res.add(matrix[top][i]);
            for(int i=top+1;i<=bottom;++i)  //最右一行上开下闭
                res.add(matrix[i][right]);
            if(left<right && bottom>top) {  //判断有没有最下一行和最左一行
                for (int i = right - 1; i > left; --i)   //最下一行左右都开
                    res.add(matrix[bottom][i]);
                for (int i = bottom; i > top; --i)   //最左一行下闭上开
                    res.add(matrix[i][left]);
            }
            bottom--;
            top++;
            right--;
            left++;
        }
        return res;
    }
}