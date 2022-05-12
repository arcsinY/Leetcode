// 下一个排列的规则：
// 1. 右边的一个大数与左边一个小数交换位置
// 2. 右边的大数尽可能靠右
// 3. 交换后大数后面的数字升序排列
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n - 2;
        // 先找出位置 i，i后面才有可能出现 >nums[i] 的数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = n - 1;
        // 找出 i 右侧的最后一个 >nums[i] 的位置 k，交换 nums[i],nums[k]
        if (i >= 0) {
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // i 后面是降序的，反转变为升序
        reverse(nums, i + 1, n - 1);
    }
    void swap(vector<int>& nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    void reverse(vector<int>& nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
};
