import java.util.HashMap;
import java.util.Map;
// 思路：先序遍历中找第一个元素为根节点，这个元素在中序中对应位置为idx。idx左侧的是左子树的中序遍历，右侧的是右子树的中序遍历。分别递归构建左右子树
// 关键：如何确定每一层递归要用到那一部分先序序列，即先序中哪一部分构成左子树
class Solution {
    Map<Integer, Integer> map = new HashMap<>();    //一个数字在中序遍历中的位置
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (preorder == null || len == 0) {
            return null;
        }
        for (int i = 0; i < len; ++i) {
            map.put(inorder[i], i);
        }
        return recover(preorder, inorder, 0, len-1, 0, len-1);
    }
    public TreeNode recover(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);  // 先序中的第一个
        int idx = map.get(preorder[preStart]);   //找出idx
        int size = idx - inStart;    // 计算左子树的节点个数：idx-1-inStart+1 = idx - inStart
        // 构建左子树，用节点个数决定要用到的先序序列中哪一部分
        root.left = recover(preorder, inorder, preStart + 1, preStart + size, inStart, idx - 1);
        // 右子树，用剩下的先序序列
        root.right = recover(preorder, inorder, preStart + 1 + size, preEnd, idx + 1, inEnd);
        return root;
    }
}
