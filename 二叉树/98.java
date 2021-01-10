// 二叉树的中序遍历，但不需要记录每一个值，只在访问根节点时记录这个值
// min记录的是已经访问的点的最大值，之后访问的点要比这个更大才符合定义
class Solution {
    double min = -Double.MAX_VALUE;  //初始的值，最小数
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }
    // 判断以root为根的二叉树是不是有效的
    public boolean traverse(TreeNode root) {
        if (root.left != null) {  // 判断左子树是否有效
            if (traverse(root.left) == false) {  // 无效直接返回false
                return false;
            }
        }
        // 根节点，要求大于当前的min
        if (root.val <= min) {
            return false;
        }
        // 访问根节点，更新min
        min = root.val;
        if (root.right != null) {  // 判断右子树是否有效
            return traverse(root.right);
        }
        return true;   // 右子树==null，返回true
    }
}
