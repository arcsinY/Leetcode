// 找出所有单调递增的区间
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = left;
        // 左指针都不需要考虑最后一天，因为最后一天买入不会有收益
        while (left < n - 1) {
          // 右指针+1与右指针判断大小，因此右指针最多到n-2
            while (right < n - 1 && prices[right + 1] > prices[right]) {   // 单调递增，则向右移动右指针。不递增时停止移动
                ++right;
            }
            if (right >= n) {
                return res + prices[right] - prices[left];
            } else {
                res += prices[right] - prices[left];
                left = right + 1;
                right = left;
            }
        }
        return res;
    }
}
