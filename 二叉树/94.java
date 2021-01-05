import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        traversal(res, root);
        return res;
    }
    public void traversal(List<Integer> res, TreeNode root){
        if(root == null)
            return;
        traversal(res, root.left);
        res.add(root.val);
        traversal(res, root.right);
    }
}
