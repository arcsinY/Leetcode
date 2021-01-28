class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        dfs(root, targetSum, res, one);
        return res;
    }
    public void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> one) {
        //走到叶子节点
        if (root.left == null && root.right == null) {
            //满足条件
            if(targetSum == root.val) {
                one.add(root.val);
                List<Integer> t = new ArrayList<Integer>(one);
                res.add(t);
                //回溯一次，尝试另一个子树
                one.remove(one.size() - 1);
                return;
            } else {
                return;
            }
        }
        one.add(root.val);
        //向右子树搜索
        if(root.left == null) {
            dfs(root.right, targetSum - root.val, res, one);
            one.remove(one.size() - 1);
        }
        //左子树搜索
        if(root.right == null) {
            dfs(root.left, targetSum - root.val, res, one);
            one.remove(one.size() - 1);
        }
        //左右都搜索，但第一个搜索之后不用remove
        if(root.left != null && root.right != null) {
            dfs(root.left, targetSum - root.val, res, one);
            dfs(root.right, targetSum - root.val, res, one);
            one.remove(one.size() - 1);
        }
    }    
}
