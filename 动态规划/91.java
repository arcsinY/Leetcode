//这题要求所有数组都用上进行解码，若不能解码成功，直接返回0
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int t = 0;
        if(s == null || len == 0 || s.charAt(0) == '0')  //第一位是0，说明第一位用不上，一定不能解码成功
            return 0;
        int[] dp = new int[len+1];   //dp[i]：从s[0]~s[i]能组合的可能数量
        dp[0] = 1;
        if(len > 1)
            t = Integer.parseInt(s.substring(0,2));   //前两位数字的组合
        else
            return dp[0];
        if(s.charAt(1) == '0' && s.charAt(0) <= '2')   //只能前两位数字一起组合
            dp[1] = 1;
        if(s.charAt(1) == '0' && s.charAt(0) > '2')    
            return 0;
        if(s.charAt(1) != '0' && t <= 26)    //既可单独组合，又能前两位一起组合
            dp[1] = 2;
        if(s.charAt(1) != '0' && t > 26)   //只能两个数字单独组合
            dp[1] = 1;
        for(int i=2;i<len;++i){
            t = Integer.parseInt(s.substring(i-1, i+1));
            if(s.charAt(i) == '0' && (s.charAt(i-1) > '2' || s.charAt(i-1) < '1'))   //这一位是0，不能合前一位组合，说明不能正常解码，直接返回0
                return 0;
            if(s.charAt(i-1) == '0'){   //前一位是0，这一位只能单独组合
                dp[i]  = dp[i-1];
                continue;
            }
            if(s.charAt(i) == '0' && s.charAt(i-1) <= '2') { //这一位是0，只能和前面一位组合
                dp[i] = dp[i - 2];
                continue;
            }
            if(s.charAt(i) != '0' && t <= 26) { //这一位不是0，且能和前一位组合
                dp[i] = dp[i - 1] + dp[i - 2];
                continue;
            }
            if(s.charAt(i) != '0' && t > 26) { //这一位不是0，但不能和前一位组合
                dp[i] = dp[i - 1];
                continue;
            }
        }
        return dp[len-1];
    }
}
