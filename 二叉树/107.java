import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> one = new ArrayList<>();
        one.add(root);   // 当前层节点只有root
        traverse(res, one);
        return res;
    }
    // res是最终结果，one是当前一层节点。将后面的节点都按层倒序加入res中，最后把当前层节点加入res
    public void traverse(List<List<Integer>> res, List<TreeNode> one) {
        if (one.size() == 0) {  // 当前层没有节点，说明上一层是叶子节点
            return;
        }
        ArrayList<TreeNode> nxt = new ArrayList<>();   // 下一层节点
        for (int i = 0; i < one.size(); ++i) {   // 计算下一层节点
            if (one.get(i).left != null) {
                nxt.add(one.get(i).left);
            }
            if (one.get(i).right != null) {
                nxt.add(one.get(i).right);
            }
        }
        traverse(res, nxt);
        // 这一层节点的值
        List<Integer> val = new ArrayList<>();
        for (int i = 0; i < one.size(); ++i) {
            val.add(one.get(i).val);
        }
        // 加入res
        res.add(val);
    }
}
