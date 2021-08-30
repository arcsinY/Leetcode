// 基本思想：构造一个包含数字 1~w.length 的数组，每个数字出现的次数为w[i]，但会超内存
// 于是使用前缀数组，构造w的前缀数组，每次随机生成一个 <= sum 的数，找到前缀数组中 <= x的最小下标i
class Solution {
    int[] pre;
    int sum;
    public Solution(int[] w) {
        int n = w.length;
        pre = new int[n];
        pre[0] = w[0];
        sum = w[0];
        for (int i = 1; i < n; ++i) {
            pre[i] = pre[i - 1] + w[i];
            sum += w[i];
        }
    }

    public int pickIndex() {
        int x = (int)(Math.random() * sum) + 1;
        return binarySearch(x);
    }
    public int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
