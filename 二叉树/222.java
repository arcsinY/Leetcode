// 先确定二叉树有几层，完全二叉树确定层数后可以确定节点个数的范围，在这个范围中二分查找。
// root的计数为1，如何判断计数为k的节点是否存在？假设有h层且k在第h层，k的二进制一定有h位，且最高位为1。
// 从根节点开始走到k节点，从k的次高位开始，若这一位 == 0，则走左孩子，否则走右孩子
// 时间复杂度O(h^2) = O((logn)^2)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode t = root.left;
        int layer = 1;
        // 共有layer层
        while (t != null) {
            ++layer;
            t = t.left;
        }
        // layer层的完全二叉树的节点个数 > 2^(h-1), <= 2^h-1
        int low = (int)Math.pow(2, layer - 1);
        int high = (int)Math.pow(2, layer) - 1;
        int mid = 0;
        while (low < high) {
            mid = (high - low + 1) / 2 + low;
            if (check(root, mid, layer)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean check(TreeNode root, int k, int layer) {
        int mask = 1 << (layer - 2);  // 用一个掩码确定k的某一位
        TreeNode t = root;
        for (int i = 1; i < layer; ++i) {
            if ((mask & k) == 0) {
                t = t.left;
            } else {
                t = t.right;
            }
            if (t == null) {
                return false;
            }
            mask >>= 1;
        }
        return true;
    }
}
