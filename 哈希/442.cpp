// 用第 x - 1 个位置记录数字 x 是否出现过。x 出现时，给 nums[x-1] 添加负号，如果这时 nums[x-1]已经是负的，说明 x 出现过了
class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            int x = abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.push_back(x);
            }
        }
        return ans;
    }
};
