// 判断平衡二叉树，等价于计算树的高度
// 规定不平衡时返回树高 = -1
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {
            return -1;
        } else {
            return Math.max(leftH, rightH) + 1;
        }
    }
}
