// 对于每个数字nums1[i]，都在nums1中寻找一个最接近nums2[i]的数字，尝试替换。最后选择最好的替换
// 将nums1赋值一次并排序，在nums1中寻找 >= nums2[i]的最小数字（搜索左侧边界）。最好的选择可能是这个数本身，也可能是这个数左边的一个数，两种情况分别讨论。
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] copy = new int[n];
        System.arraycopy(nums1, 0, copy, 0, n);
        Arrays.sort(copy);
        long ans = 0;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            int t = Math.abs(nums1[i] - nums2[i]);
            ans += t;
            int idx = search(copy, nums2[i]);
            if (idx < n) {
                max = Math.max(max, t - Math.abs(copy[idx] - nums2[i]));
            }
            if (idx > 0) {
                max = Math.max(max, t - Math.abs(copy[idx - 1] - nums2[i]));
            }
        }
        return (int)((ans - max) % (1e9 + 7));
    }

    public int search(int[] num, int target) {
        int low = 0, high = num.length - 1;
        // num中所有数都小于target，返回最后一个位置，只可能是这个元素是好的替换
        if (target > num[high]) {
            return num.length;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // num中所有数都大于target时，low == 0，只可能是这个数是好的替换
        return low;
    }
}
