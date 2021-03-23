// 先从左向右遍历，若i+1>i，则i+1要比前一个孩子得到多一个糖果
// 再从右向左遍历，若i>i+1，则i要多得到一个糖果
// 两者取最大的作为第i个孩子实际得到的糖果
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int res = 0;
        left[0] = 1;
        for(int i = 0; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 1;
        res += left[n - 1];
        for (int i = n - 2; i >= 0; ++i) {
            if (ratings[i] > ratings[i + 1]) {
                ++right;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }
}
