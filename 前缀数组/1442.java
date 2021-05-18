// pre[i]: arr[0]~arr[i-1]的异或
// arr[i]~arr[j]的异或 = pre[j + 1] ^ pre[i]
// 题目要求pre[j] ^ pre[i] == pre[k] ^ pre[j]，等价于pre[i] == pre[k]，(i+1) ~ k之间的的 j 都满足要求
// 如果有m个pre[i] == pre[k + 1]，则结果数量 += mk - 所有的i之和
class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        int[] pre = new int[arr.length + 1];
        pre[0] = arr[0];
        for (int i = 0; i < arr.length; ++i) {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        Map<Integer, Integer> cnt = new HashMap<>();   // 记录pre中结果为 key 的元素数量
        Map<Integer, Integer> sum = new HashMap<>();   // 记录pre中结果为key的元素下标和
        for (int i = 0; i < arr.length; ++i) {
            if (cnt.containsKey(pre[i + 1])) {
                res += cnt.get(pre[i + 1]) * i - sum.get(pre[i + 1]);
            }
            cnt.put(pre[i], cnt.getOrDefault(pre[i], 0) + 1);
            sum.put(pre[i], sum.getOrDefault(pre[i], 0) + i);
        }
        return res;
    }
}
