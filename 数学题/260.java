// 如果只有一个元素出现两次，所有元素异或可得到结果
// 因此将元素分为两组，保证出现两次的数（x和y）分在不同组，分别对两组异或
// 如何将出现两次的数分在不同两组？对所有数异或，得到的结果是x^y的值。（x^y）的第i个二进制位 == 1，说明x和y的第i位不同
// 因此可以按照所有数的第i位是0还是1来划分
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int digit = 1;
        while ((xor & digit) == 0) {
            digit <<= 1;
        }
        int res1 = 0, res2 = 0;
        for (int i : nums) {
            if ((i & digit) != 0) {
                res1 ^= i;
            } else {
                res2 ^= i;
            }
        }
        return new int[]{res1, res2};
    }
}
