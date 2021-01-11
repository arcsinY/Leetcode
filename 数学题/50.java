// 快速幂运算：计算x的n次幂
// 如果x的第i个二进制位 == 1，则结果中包含x^2^i这一因子，否则不包含
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {  //只计算n>0的情况，若n<0最后对结果取相反数
            N *= -1;
        }
        double res = 1;   
        double base = x;    //每次要乘上的因子
        while (N > 0) {
            if ((N & 1) == 1) {   //取N的最低位，是1则乘上目前的因子
                res *= base;
            }
            base *= base;   //当前因子平方，代表从x^2^i 计算出 x^2^(i+1)
            N >>= 1;  //N左移一位，等价于N/2。看下一个二进制位
        }
        if (n >= 0) {
            return res;
        }
        return 1/res;
    }
}
