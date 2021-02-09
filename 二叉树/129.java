class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 0);
    }
    // 目前已有的路径和为sum，从root节点开始继续计算
    public int dfs(TreeNode root, int sum) {
        // 找到叶子节点
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        sum = sum * 10 + root.val;  // 访问过这个节点后，更新现有的sum
        int a = 0, b = 0;
        // 左右子树继续计算，将结果求和
        if (root.left != null) {
            a = dfs(root.left, sum);
        }
        if (root.right != null) {
            b = dfs(root.right, sum);
        }
        return a + b;
    }
}
