// 两个数的第 i 位分别记为u1,u2，前一位的进位记为t
// (1) u1 == 1 && u2 == 1 && t == 1，结果的第 i 位 = 1，t = 1
// (2) u1 == 1 && u2 == 1 && t == 0，结果的第 i 位 = 0，t = 1
// (3) u1,u2其中一个 == 1 && t == 1，结果的第 i 位 = 0，t = 1
// (4) u1,u2其中一个 == 1 && t == 0，结果的第 i 位 = 1，t = 0
// (5) u1 == 0 && u2 == 0 && t == 1，结果的第 i 位 = 1，t = 0
// (6) u1 == 0 && u2 == 0 && t == 0，结果的第 i 位 = 0，t = 0
class Solution {
    public int getSum(int a, int b) {
        int ans = 0;
        int t = 0;
        for (int i = 0; i < 32; ++i) {
            int u1 = (a >> i) & 1;
            int u2 = (b >> i) & 1;
            if (u1 == 1 && u2 == 1) {
                ans |= (t << i);
                t = 1;
            } else if (u1 == 1 || u2 == 1) {
                if (t == 0) {
                    ans |= (1 << i);
                } else {
                    ans &= ~(1 << i);
                }
            } else {
                ans |= (t << i);
                t = 0;
            }
        }
        return ans;
    }
}
