import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (inorder == null || postorder == null || len == 0) {
            return null;
        }
        for (int i = 0; i < len; ++i) {
            map.put(inorder[i], i);
        }
        return rebuild(inorder, postorder, 0, len-1, 0, len - 1);
    }
    public TreeNode rebuild(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        // 根节点
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        // 找中序中的位置
        int inIdx = map.get(val);
        // 计算左子树的长度
        int leftSize = inIdx - inStart;
        // 后序遍历的前半部分是左子树，后半部分右子树
        root.left = rebuild(inorder, postorder, inStart, inIdx - 1, postStart, postStart + leftSize - 1);
        root.right = rebuild(inorder, postorder, inIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
        return root;
    }
}
