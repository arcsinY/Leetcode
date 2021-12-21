// 计算：对应的数字是几位数 --> 对应的数字是几 --> 需要返回对应的数字中的第几位（从左往右）
public class Solution {
    public int findNthDigit (int n) {
        int d = 1, cnt = 9;
        // 计算出对应的数字是 d 位数
        while (n > (long) d * cnt) {
            n -= d * cnt;
            d++;
            cnt *= 10;
        }
        // 对应数字在所有 d 位数中的偏移量（从0开始）
        int offset = (n - 1) / d;
        // 第0个 d 位数
        int start = (int)Math.pow(10, d - 1);
        // 第 n 位数字是对应数字中的第几位（从左往右，从0开始）
        int numOffset = (n - 1) % d;
        // 对应的数字是几
        int realNum = offset + start;
        // 在 realNum 中取出第 numOffset 位数字
        return (realNum / (int)Math.pow(10, d - numOffset - 1)) % 10;
    }
}
