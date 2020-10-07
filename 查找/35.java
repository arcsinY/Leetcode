class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0]>target || nums.length == 0)
            return 0;
        if(nums[nums.length-1]<target)
            return nums.length;
        int low =  0;
        int high=nums.length-1;
        int mid=0;
        while (low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        if(nums[mid]>target)
            return mid;
        else
            return mid+1;
    }
}