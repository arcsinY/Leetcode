// 同余定理：(a - b) % m == 0 等价于 a % m == b % m
// 前缀和(sum[i]-sum[j]) % k == 0说明i~(j - 1)之间的元素和为k的倍数，要求i - (j - 1) >= 1，即i - j >= 2
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);   // 前两个元素和为k的倍数才行，此时i == 1，为了达到i - j >= 2的要求，这里设置为-1
        for (int i = 0; i < nums.length; ++i) {
            int t = sum[i] % k;
            if (map.containsKey(t)) {
                int index = map.get(t);
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(t, i);
            }
        }
        return false;
    }
}
