class Solution {
    public void nextPermutation(int[] nums) {
        int i;int j=nums.length-1;
        int t=nums[nums.length-1];
        for(i=nums.length-1;i>=1;--i)  //找到后一个元素比前一个元素大的地方
        {
            if(nums[i]>nums[i-1])
                break;
        }
        if(i<1)  //已经是最大字典序了，直接反转
        {
            while(i<j)
            {
                t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                ++i;--j;
            }
            return;
        }
        int min_index=i;  //找到从nums[i-1]之后比nums[i-1]小的最大数，同时要求尽可能靠右
        for(int k=i;k<= nums.length-1;++k)
        {
            if(nums[k]>nums[i-1] && nums[k]<=nums[min_index])
                min_index=k;
        }
        t=nums[min_index];  //交换这两个数
        nums[min_index]=nums[i-1];
        nums[i-1]=t;
        while(i<j)  //nums[i-1]之后的部分反转
        {
            t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            ++i;--j;
        }
    }
}