class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String one = new String();
        traverse(root, one, res);
        return res;
    }
    // 为什么参数是String类型，而不直接传StringBuilder修改？因为回溯到上一层后没法删除刚刚做过的选择
    public void traverse(TreeNode root, String one, List<String> res) {
        StringBuilder t = new StringBuilder(one);
        if (root.right == null && root.left == null) {
            t.append(String.valueOf(root.val));
            res.add(new String(t));
        }
        t.append(String.valueOf(root.val)+"->");
        if (root.left != null) {
            traverse(root.left, t.toString(), res);
        }
        if (root.right != null) {
            traverse(root.right, t.toString(), res);
        }
    }
}
