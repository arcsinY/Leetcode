class Solution {
    int res = 0;
    public int maxDepth(TreeNode root) {
        int depth = 0;
        traverse(root, depth);
        return res;
    }
    public void traverse(TreeNode root, int depth) {
        if (root == null) {
            if (depth > res) {
                res = depth;
            }
            return;
        }
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }
}
