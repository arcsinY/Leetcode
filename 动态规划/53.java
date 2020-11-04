import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int dp=nums[0];
        for(int i=1;i<nums.length;++i)
        {
            dp=Math.max(nums[i],dp+nums[i]);  //从nums[i]开始一个新的子序列，或将nums[i]加到前一个子序列上
            max = Math.max(max, dp);
        }
        return max;
    }
}