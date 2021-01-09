import java.util.ArrayList;
import java.util.List;
// 对start~end的数组建立排序二叉树，选定一个数字i为根，递归对start~(i-1)建立左子树，对(i+1)~end建立右子树
// 特别注意递归出口是什么，什么时候加入null
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        return dfs(1,n);
    }
    // 返回的是根节点列表
    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        // 递归出口
        if(start > end){
            res.add(null);
            return res;
        }
        // 遍历所有根节点
        for(int i = start; i <= end; ++i) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            // 任选一个左子树和一个右子树，拼接在当前根节点上
            for(int j = 0; j < left.size(); ++j) {
                for(int k = 0; k < right.size(); ++k) {
                    TreeNode t = new TreeNode(i);
                    t.left = left.get(j);
                    t.right = right.get(k);
                    res.add(t);  // 得到一个根节点
                }
            }
        }
        return res;
    }
}
