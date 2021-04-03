// 一个数不断getNext的可能性：
// 1. 达到1
// 2. 形成循环
// 3. 不断增大
// 第三种情况不可能出现，因为四位数及以上的数每次getNext都会减少一位，直到降为3位数，3位数getNext最大为243
// 因此问题转化为：不断getNext，是否会出现循环。使用快慢指针，一个每次走两步，一个每次走一步。若有循环则一定相遇
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (true) {
            if (fast == 1 || slow == 1) {
                return true;
            }
            if (fast == slow) {
                return false;
            }
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
    }
    public int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int t = n % 10;
            res += t * t;
            n /= 10;
        }
        return res;
    }
}
