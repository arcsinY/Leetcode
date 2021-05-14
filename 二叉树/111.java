// BFS求解，效率高于DFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            int size = q.size();
            // 这一层的节点
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.poll();
                // 到了跟节点
                if (t.left == null && t.right == null) {
                    return res + 1;
                }
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            ++res;
        }
        return res;
    }
}
