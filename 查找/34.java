class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[] {-1,-1};
        int left = search(nums,target,true);
        int right = search(nums,target, false)-1;
        //查找失败会有三种情况：
        //1. target<nums[0]，此时left==0，right=-1
        //2. target>nums[nums.length-1]，此时left=nums.length，right=nums.length
        //3. left和right在随机的一个合法下标
        if(left < nums.length && nums[left] == target)
            return new int[] {left,right};
        else
            return new int[] {-1,-1};
    }
    //findLeft == true时，寻找最左侧的index。否则寻找最右的
    //findLeft == true时，查找成功后，low是正确的位置。findLeft == false时，查找成功后，low是正确位置+1，因为最后一次循环会执行low=mid+1
    public int search(int[] nums, int target, boolean findLeft)
    {
        int low=0, high=nums.length-1;
        int mid=(low+high)/2;
        while(low<=high)
        {
            if((nums[mid] == target && findLeft == true) || nums[mid]>target )  //找到了以个target，由于想要在更左侧寻找target，所以在左侧继续寻找
            {
                high=mid-1;
                mid=(high+low)/2;
            }
            else
            {
                low=mid+1;
                mid=(high+low)/2;
            }
        }
        return low;
    }
}