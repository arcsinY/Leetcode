// sum[i]：nums[0]~nums[i]的和
// 计算sum[i]后，可以计算每个子数组的和，复杂度O(n^2)
// 若子数组和 == k，则sum[i] - sum[j - 1] == k，因此有多少个sum[j - 1] == sum[i] - k，就有多少个以nums[i]为结尾的子数组，用哈希表存储sum[j - 1]，线性复杂度
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);    // sum[i] == k的情况
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
