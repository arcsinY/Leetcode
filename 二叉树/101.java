import java.util.Deque;
import java.util.LinkedList;
// 层次遍历的改变：按照同一层从两端到中间的顺序层次遍历
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> q = new LinkedList<>();
        // 每次出队两个，所以根节点加入两次
        q.push(root);
        q.push(root);
        while (q.isEmpty() == false) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if (a == null && b == null) {
                continue;
            }
            if (a == null || b == null || (a.val != b.val)) {
                return false;
            }
            // 对称将孩子入队
            q.push(a.left);
            q.push(b.right);
            q.push(a.right);
            q.push(b.left);
        }
        return true;
    }
}
