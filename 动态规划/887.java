// 为什么不能二分查找？因为鸡蛋数量有限，也就是错误尝试的次数有限。比如只有1个鸡蛋，就只能从低到高查找
// 状态：用k个鸡蛋，n层楼，需要尝试几次
// 选择：每一次可以选择从1~n楼尝试扔鸡蛋
// 转移：若碎了，则剩余k-1个鸡蛋，从i-1层中找答案。若没碎，剩余k个鸡蛋，从n-i层楼中找答案，两者之中选最大的（最坏情况）。时间复杂度O(kn^2)
// 优化：第一种情况随i增大是递增的，第二种情况随i增大是递减的，两者的最大值的最小 = 两种情况的交点。使用二分查找找到交点，时间复杂度O(knlogn)
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] mem = new int[k + 1][n + 1];   // 备忘录
        for (int i = 0; i <= k; ++i) {
            for (int j = 0; j <= n; ++j) {
                mem[i][j] = -1;
            }
        }
        return dp(k, n, mem);
    }
    public int dp(int k, int n, int[][] mem) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        // 查找备忘录 
        if (mem[k][n] != -1) {
            return mem[k][n];
        }
        int res = Integer.MAX_VALUE;
        int low = 1;
        int high = n;
        int mid = 0;
        // 二分查找
        while (low <= high) {
            mid = (low + high) / 2;
            int t1 = dp(k - 1, mid - 1, mem);
            int t2 = dp(k, n - mid, mem);
            if (t1 > t2) {
                high = mid -1;
                res = Math.min(res, t1 + 1);
            } else {
                low = mid + 1;
                res = Math.min(res, t2 + 1);
            }
        }
        mem[k][n] = res;
        return res;
    }
}
