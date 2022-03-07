// 某个节点的最大路径和：以该节点为根的子树上，经过该节点的最大路径和
// 一个节点的maxGain：以该节点为根的子树上，从该节点出发的最大路径和
// maxGain = node.val + max(maxGain(node.left) + maxGain(node, right))
class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return sum;
    }
    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        sum = Math.max(sum, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}
