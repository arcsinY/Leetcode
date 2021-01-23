// 二叉搜索树的中序遍历对应着一个有序数组。将输入的数组看作二叉树的中序遍历。为保证平衡，每次取中间节点作为根，左半部分递归建立左子树，右半部分建立右子树
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return null;
        }
        return build(nums, 0, len - 1);
    }
    TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;   // 中间节点
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
