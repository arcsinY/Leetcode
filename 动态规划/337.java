class Solution {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }
    // 返回大小 = 2的数组，[0]表示不抢root的收益，[1]表示抢root的收益
    // 计算过程等价于二叉树的遍历，时间复杂度O(n)
    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢root，不能抢左右孩子
        int yes = root.val + left[0] + right[0];
        // 不抢root，左右孩子可抢可不抢，取最大的
        int no = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{no, yes};
    }
}
