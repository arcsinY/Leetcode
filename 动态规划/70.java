class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        int prepre=1;
        int pre=1;
        int now = 0;
        for(int i=2;i<=n;++i)
        {
            now = pre+prepre;
            prepre = pre;
            pre = now;
        }
        return now;
    }
}