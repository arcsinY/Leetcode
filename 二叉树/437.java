// 前缀和：从root到某一个node的路径上所有节点val的和
// 用map记录：从root到当前node的路径上，出现的所有前缀和以及对应的数量
// 从root到当前node的路径和为cur，寻找前缀和为cur-target的，去掉这部分的路径和为target
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, map, 0, targetSum);
    }
    public int dfs(TreeNode root, Map<Integer, Integer> map, int cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        cur += root.val;
        ans += map.getOrDefault(cur - targetSum, 0);
        // 更新前缀和为cur的数量
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        ans += dfs(root.left, map, cur, targetSum);
        ans += dfs(root.right, map, cur, targetSum);
        // 退出当前节点，将前缀和为cur的数量 - 1
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        return ans;
    }
}
