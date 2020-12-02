class Solution {
    public boolean canJump(int[] nums) {
        int far=0;//记录能跳到的最远距离
        for(int i=0;i<nums.length-1 && i<=far;++i)   //遍历能跳到的数字，不包括最后一个数
        {
            if(i+nums[i]>far)
                far=i+nums[i];   //更新far
        }
        if(far >= nums.length-1)
            return true;
        return false;
    }
}