// 问题等价于计算两个端点left, right的公共二进制前缀
// 在left和right的公共二进制前缀之后的部分，每一位一定是既有0又有1的，因此在按位与之后全部为0。
// 将left和right同时按位右移，当两数相等时，得到了两数的公共二进制前缀，之后将其中一个数左移同样的位数，得到结果
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;   // 记录两个数右移的次数
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
