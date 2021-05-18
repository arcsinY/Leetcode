// dp[i]: 第 i 个丑数
// 选择：下一个丑数一定是现有丑数*2，*3，*5的最小值
// 但不能直接用最小数*2计算下一个个丑数，因为这个数可能已经计算过了。
// 三个指针p2,p3,p5：下一个丑数是对应的现有丑数的*2，*3，*5
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; ++i) {
            int t1 = dp[p2] * 2;
            int t2 = dp[p3] * 3;
            int t3 = dp[p5] * 5;
            dp[i] = Math.min(t1, Math.min(t2, t3));
            if (dp[i] == t1) {
                ++p2;
            } 
            if (dp[i] == t2) {
                ++p3;
            } 
            if (dp[i] == t3) {
                ++p5;
            }
        }
        return dp[n];
    }   
}
