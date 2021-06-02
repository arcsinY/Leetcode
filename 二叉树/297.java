// 按照先序遍历的顺序进行序列化，遇到空节点记为"null"
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        dfs(root, s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> strings = new ArrayList<>(Arrays.asList(data.split(",")));
        return dfs(strings);
    }

    public void dfs(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("null,");
        }
        s.append(String.valueOf(root.val));
        dfs(root.left, s);
        dfs(root.right, s);
    }

    public TreeNode dfs(List<String> s) {
        // 遇到"null"，这个节点是null
        if (s.get(0).equals("null")) {
            return null;
        }
        TreeNode res = new TreeNode();
        res.val = Integer.parseInt(s.get(0));
        s.remove(0);
        res.left = dfs(s);
        res.right = dfs(s);
        return res;
    }
}
