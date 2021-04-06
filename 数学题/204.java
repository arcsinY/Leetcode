// 埃氏筛法
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int res = 0;
        Arrays.fill(isPrime, true);
        // 从第一个质数2开始
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                ++res;
                // 判断i*i是否小于n，避免溢出
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return res;
    }
}
