class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return  -1;
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[0]<=nums[mid])  //mid在交换位置之前，mid左侧的都比nums[mid]小，但大于nums[0]
            {
                if(nums[0]<=target && target<nums[mid])   //在左侧寻找
                    high=mid-1;
                else
                    low=mid+1;
            }
            else   //mid在交换位置之后，mid右侧的数有序，都大于nums[mid]但小于nums[nums.length-1]
            {
                if(nums[mid]<target && target <=nums[nums.length-1])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}