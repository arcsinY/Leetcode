// 快速幂运算：计算x的n次幂
// 计算公式：如果x的第 i 个二进制位 == 1，则结果中包含 x^2^i 这一因子，否则不包含
class Solution {
    public double myPow(double x, int n) {
        long N = n;   // 如果n == INT_MIN，则取相反数之后会溢出int，因此转换为long
        if (n < 0) {  //只计算n>0的情况，若n<0最后对结果取倒数
            N *= -1;
        }
        double ans = 1;   
        double base = x;    //每次要乘上的因子
        while (N > 0) {
            if ((N & 1) == 1) {   //取 N 的最低位，是 1 则乘上目前的因子
                ans *= base;
            }
            base *= base;   //当前因子平方，代表从 x^2^i 计算出 x^2^(i+1)
            N >>= 1;  //N右移一位，等价于N/2。看下一个二进制位
        }
        if (n >= 0) {
            return ans;
        }
        return 1/ans;
    }
}
