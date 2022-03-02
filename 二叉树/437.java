// 前缀和：从 root 到某一个 node 的路径上所有节点 val 的和
// 用 map 记录：从 root 到当前 node 的路径上，出现的所有前缀和以及对应的数量
// 从 root 到当前 node 的路径和为 cur，寻找前缀和为 cur-target 的，去掉这部分的路径和为 target
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, map, 0, targetSum);
    }
    // 返回从 root 出发，当前路径和为 cur，目标为 targetSum 的路径数量
    public int dfs(TreeNode root, Map<Integer, Integer> map, int cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        cur += root.val;
        ans += map.getOrDefault(cur - targetSum, 0);
        // 更新前缀和为 cur 的数量
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        ans += dfs(root.left, map, cur, targetSum);
        ans += dfs(root.right, map, cur, targetSum);
        // 退出当前节点，将前缀和为 cur 的数量 -1
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        return ans;
    }
}
