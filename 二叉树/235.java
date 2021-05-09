// 由于是二叉搜索树，可以快速从根节点找到目标节点，得到路径。比较两条路径，最后一个相同位置就是最近公共祖先
// 同时搜索两个目标节点，避免存储路径。如果p,q都在当前节点的左子树或右子树上，可继续搜索，否则当前节点就是结果
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (true) {
            if (res.val > p.val && res.val > q.val) {
                res = res.left;
            } else if (res.val < p.val && res.val < q.val) {
                res = res.right;
            } else {
                break;
            }
        }
        return res;
    }
}
