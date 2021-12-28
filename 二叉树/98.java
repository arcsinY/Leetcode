// 二叉树的中序遍历，但不需要记录每一个值，只记录已经访问过的最大值，后面的访问都要比这个值大
// min记录的是已经访问的点的最大值，访问一个节点时更新这个值
class Solution {
    long min = -Long.MAX_VALUE;  //初始的值，最小数
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }
    // 判断以root为根的二叉树是不是有效的
    public boolean traverse(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!traverse(root.left)) {  // 无效直接返回false
            return false;
        }
        // 根节点，要求大于当前的min
        if (root.val <= min) {
            return false;
        }
        // 访问根节点，更新min
        min = root.val;
        // 判断右子树是否有效
        return traverse(root.right);
    }
}
