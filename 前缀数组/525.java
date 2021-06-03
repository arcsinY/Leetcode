// 将数组中的0转换为-1，0和1的数量相等 <==> 和为0的最长连续子数组，变成了前缀数组问题
// 并不需要真的转换数组和计算前缀数组，而是用单一变量记录前缀和，哈希表记录前缀数组。
// 第i位置前缀和 == 第j位置前缀和（j > i），说明nums[i-1]~nums[j]之间的元素和 == 0，这个子数组长度 == j - i
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);   // 设i位置的前缀和为0，说明nums[0]~nums[i]的子数组和为0，这个子数组长度为i+1，因此map中0对应-1
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                --sum;
            } else {
                ++sum;
            }
            if (map.containsKey(sum)) {
                int index = map.get(sum);
                if (i - index > res) {
                    res = i - index;
                }
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
