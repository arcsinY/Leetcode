// 遍历数组中每个数，假设数组中有一个数x，使用HashSet判断有没有x+1,x+2,..,x+y
// 访问一个数x时，先判断数组中有没有x-1，若有，说明包含x的连续序列已经找到过，不需要从x开始寻找连续序列
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }
        for (int i : set) {
            if (set.contains(i-1) == true) {
                continue;
            }
            int num = i + 1;
            int length = 1;
            while (set.contains(num)) {
                ++length;
                ++num;
            }
            if (length > res) {
                res = length;
            }
        }
        return res;
    }
}
