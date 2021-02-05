import java.util.List;
// 基本解法：每一行设定一个dp数组，dp[i][j]表示走到第i行、第j个元素是取得的最小路径。这样的空间复杂度为O(n^2)
// 改进：只有两个dp数组，第1个个记录奇数行各个位置的最小路径，第2个记录偶数行的。空间复杂度O(2n)
// 继续改进：每一行从右向左遍历，因为只需要用到dp[i][j-1]和dp[i][j]的数据，因此计算新的dp[i][j]时dp[i][j-1]还没修改过，依然是上一行的数据
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int res = Integer.MAX_VALUE;
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (dp[i] < res) {
                res = dp[i];
            }
        }
        return res;
    }
}
