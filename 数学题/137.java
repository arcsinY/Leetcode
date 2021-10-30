// 一个数字出现三次，这三个数字之和的第i个二进制位 == 3 或 == 0
// n个数字，每个出现三次，这3n个数字之和的第i个二进制位一定是三的倍数
// 所有数字求和，第i个二进制位不是3的倍数，则只出现一次的那个数字的第i位 == 1
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int j : nums) {
                total += (j >> i) & 1;
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
