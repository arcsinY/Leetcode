class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0)
            return;
        int p0=0,p1=0;  //p0记录找到一个0时要放置的位置，p1记录找到一个1时放置的位置
        for(int i=0;i<len;++i)
        {
            if(nums[i] == 1)   //找到1，放在p1位置
            {
                int t = nums[p1];
                nums[p1] = nums[i];
                nums[i] = t;
                ++p1;
            }
            else if(nums[i] == 0)
            {
                int t = nums[p0];   //找到0，放在p0位置
                nums[p0] = nums[i];
                nums[i] = t;
                if(p0<p1)   //说明放置的0覆盖了1，有一个1放在了nums[i]处
                {
                    t = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = t;
                }
                ++p1;++p0;
            }
        }
    }
}