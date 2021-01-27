class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return judge(root, targetSum);
    }
    boolean judge(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //走到叶子节点了，叶子节点值==剩余需要的值
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                return true;
            }
            return false;
        }
        if (root.left == null) {
            return judge(root.right, targetSum - root.val);
        }
        if (root.right == null) {
            return judge(root.left, targetSum - root.val);
        }
        return judge(root.left, targetSum - root.val) || judge(root.right, targetSum - root.val);
    }
}
