//计算格雷码：从0位格雷码=0开始递推
//每次计算n+1位格雷码时，首先将n位格雷码所有数在最高位添加0（不变）
//之后按n位格雷码的倒序，在每个数字最高为添加1
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int addOne = 1;  //在首位添加1，转化为与某个数的加法
        for(int i=0;i<n;++i) {
            for(int j=res.size()-1;j>=0;--j){
                res.add(addOne + res.get(j));
            }
            addOne <<= 1;   //让1的位置向前一位
        }
        return res;
    }
}
