// 要求空间复杂度O(h)，因此不能存储中序遍历结果
// 假设当前得到的最小值节点为叶子节点，下一个最小值是其双亲
// 假设当前最小值不是叶子节点，下一个最小值是其右节点的最左节点
// 寻找最左节点的过程中，使用栈来保存所有经过的节点
class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        pushLeft(root);
    }

    public int next() {
        TreeNode res = stack.getFirst();
        stack.removeFirst();
        if (res.right == null) {
            return res.val;
        }
        pushLeft(res.right);
        return res.val;
    }
  
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    // 寻找root的最左节点，存入栈中（包括root）
    public void pushLeft(TreeNode root) {
        while (root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
