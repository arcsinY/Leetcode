// 异或运算：与自身异或=0，与0异或=自身，满足结合律和交换律
// 根据以上性质，数组中所有元素异或=(a1^a1)^(a2^a2)^...^am = am。其中am是唯一出现的元素，其他元素出现两次，结果得0
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}
