// 在左右子树都==null时才能回溯，一个为null则需继续搜索另一个子树
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftH = Integer.MAX_VALUE, rightH = Integer.MAX_VALUE;
        if (root.left != null) {
            leftH = minDepth(root.left);
        }
        if (root.right != null) {
            rightH = minDepth(root.right);
        }
        return Math.min(leftH, rightH) + 1;
    }
}
