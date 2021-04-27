class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<String>();
        }
        int left = 0, right = 1;
        List<String> res = new ArrayList<>();
        while (right < nums.length) {
            // 最大数-最小数会溢出int的范围
            if ((long)nums[right] - nums[right - 1] > 1) {
                if (right - 1 - left == 0) {
                    res.add(Integer.toString(nums[left]));
                } else {
                    res.add(Integer.toString(nums[left]) + "->" + Integer.toString(nums[right - 1]));
                }
                left = right;
            }
            ++right;
        }
        if (left != right - 1) {
            res.add(Integer.toString(nums[left]) + "->" + Integer.toString(nums[right - 1]));
        } else {
            res.add(Integer.toString(nums[left]));
        }
        return res;
    }
}
