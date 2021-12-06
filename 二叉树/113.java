class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        dfs(root, targetSum, ans, one);
        return ans;
    }
    public void dfs(TreeNode root, int num, List<List<Integer>> ans, List<Integer> one) {
        if (root == null) {
            return;
        }
        one.add(root.val);
        num -= root.val;
        if (num == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList(one));
            one.remove(one.size() - 1);
            return;
        }
        dfs(root.left, num, ans, one);
        dfs(root.right, num, ans, one);
        one.remove(one.size() - 1);
    }
}
