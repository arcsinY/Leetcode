class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int p=1;   //要覆盖的位置
        int cnt=1;  //同一数字计数
        for(int i=1;i<nums.length;++i) {
            if(nums[i] == nums[i-1]) {
                cnt++;
            }
            else
                cnt=1;
            if(cnt<=2) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
