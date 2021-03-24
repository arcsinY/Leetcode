// 数组中最大数为max，最小min。任意两数间距 < (max-min)/(n-1)
// 使用桶排序，每个桶保存的数据范围 < (max-min)/(n-1)。可以保证排序后的最大间距不在每个桶内部，而在两个桶之间
// 两个桶之间的最大间距 = 后一个桶的最大值-前一个的最小值
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int d = Math.max((max - min) / (n - 1), 1);
        int binNum = (max - min) / d + 1;   // 桶的数量
        int[] minEachBin = new int[binNum];   // 每个桶的小值，-1表示没有元素存入
        Arrays.fill(minEachBin, -1);
        int[] maxEachBin = new int[binNum];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int binId = (nums[i] - min) / d;
            if (minEachBin[binId] == -1) {
                minEachBin[binId] = nums[i];
                maxEachBin[binId] = nums[i];
            } else {
                minEachBin[binId] = Math.min(minEachBin[binId], nums[i]);
                maxEachBin[binId] = Math.max(maxEachBin[binId], nums[i]);
            }
        }
        int pre = -1;
        for (int i = 0; i < binNum; ++i) {
            if (minEachBin[i] == -1) {
                continue;
            }
            if (pre != -1) {
                res = Math.max(res, minEachBin[i] - maxEachBin[pre]);
            }
            pre = i;
        }
        return res;
    }
}
