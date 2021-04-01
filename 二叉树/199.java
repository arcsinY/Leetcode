// 二叉树层次遍历，每一层最又侧的节点就是这一层的结果
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> thisLayer = new LinkedList<>();  // 本层节点
        Queue<TreeNode> nextLayer = new LinkedList<>();  // 下一层节点
        thisLayer.add(root);
        while (thisLayer.isEmpty() == false) {
            TreeNode t = thisLayer.poll();
            if (t.left != null) {
                nextLayer.add(t.left);
            }
            if (t.right != null) {
                nextLayer.add(t.right);
            }
            if (thisLayer.isEmpty()) {
                res.add(t.val);
                thisLayer = new LinkedList<>(nextLayer);
                nextLayer.clear();
            }
        }
        return res;
    }
}
