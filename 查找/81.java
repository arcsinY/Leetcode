class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length== 0)
            return false;
        int left = 0,right = nums.length-1;
        int mid;
        while(left<=right)
        {
            mid = (left+right)/2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] == nums[left])
            {
                ++left;
                continue;
            }
            if(nums[left]<nums[mid])  //前面有序
            {
                if(nums[left]<=target && nums[mid]>target)
                    right = mid-1;
                else
                    left = mid +1;
            }
            else
            {
                if(nums[mid]<target && nums[right]>=target)
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return false;
    }
}
