// 先从左向右遍历，后从右向左遍历
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // res[i]：nums[i]之前的元素乘积
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int t = 1;   // t：nums[i]之后的元素乘积
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= t;
            t *= nums[i];
        }
        return res;
    }
}
