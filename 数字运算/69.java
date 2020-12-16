class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        double xi = x;
        double pre = x;
        while(true)
        {
            xi = 0.5*(xi+(double)x/xi);
            if(Math.abs(pre-xi)<1e-7)
            {
                break;
            }
            pre = xi;
        }
        return  (int)xi;
    }
}