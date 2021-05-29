// 矩阵的前缀和：先将矩阵按列求和转化为数组，再计算数组的 “和为k子数组问题”
// 矩阵按列求和：行的范围从i~m，遍历i，保证覆盖所有子矩阵
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i) {
            int[] sum = new int[n];
            // 从第i行开始按列求和，每列的和是数组中一个元素
            for (int j = i; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    sum[k] += matrix[j][k];
                }
                res += subarraySum(sum, target);
            }
        }
        return res;
    }
    // 和为k子数组问题
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
