class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = true;
        int result=0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            positive=false;
        dividend=-Math.abs(dividend);   //都用负数计算，避免溢出
        divisor=-Math.abs(divisor);
        int t,c;
        while(dividend<= divisor)
        {
            t=divisor;
            c=1;
            while(dividend-t<=t)
            {
                t<<=1;
                c<<=1;
            }
            dividend-=t;  //每次减去c个divisor，c*divisor=t
            result += c;
        }
        if(positive)
            return result;
        else
            return -result;
    }
}