// 访问到要查询的节点时，记录其parent
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode parent = null;
        while (q.isEmpty() == false) {
            int size = q.size();
            boolean flag = false;   // 下一层是否出现了查询节点
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.poll();
                if (t.left != null) {
                    if (t.left.val == x || t.left.val == y) {
                        if (flag && parent != t) {   // 下一层出现了另一个查询节点，说明两个节点深度相同
                            return true;
                        } else if (flag && parent == t){
                            return false;
                        }
                        flag = true;
                        parent = t;
                    }
                    q.add(t.left);
                }
                if (t.right != null) {
                    if (t.right.val == x || t.right.val == y) {
                        if (flag && parent != t) {
                            return true;
                        } else if (flag && parent == t){
                            return false;
                        }
                        flag = true;
                        parent = t;
                    }
                    q.add(t.right);
                }
            }
            if (flag) {  // 下一层只出现了一个查询节点，说明两个节点深度不同
                return false;
            }
            flag = false;
        }
        return true;
    }
}
