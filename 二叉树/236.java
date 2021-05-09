// p,q两个节点分别包含在某一个节点的左右子树中，这个节点就是最近公共祖先
// 树中既没有p有没有q时返回null
// 树中有p和q时返回最近公共祖先
// 有p，q其中之一时返回对应的节点
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode lChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rChild = lowestCommonAncestor(root.right, p, q);
        // p，q分别在左右子树
        if (lChild != null && rChild != null) {
            return root;
          // 都在右子树
        } else if (lChild == null) {
            return rChild;
        } else {
            return lChild;
        }
    }
}
