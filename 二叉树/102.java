import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
// 层次遍历，但由于要分层，因此要记录每一层有几个元素。遍历一层时，只从队列中取出这几个元素
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();  // 一层的节点
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        int num = 1;  // 这层的元素个数
        int nextNum = 0;   // 下一层的元素个数，在遍历这层时计算出来
        q.push(root);
        while (q.isEmpty() == false) {
            TreeNode t;
            for (int i = 0; i < num; ++i) {
                t = q.poll();
                layer.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                    ++nextNum;   // 有左孩子，下一层个数+1
                }
                if (t.right != null) {
                    q.add(t.right);
                    ++nextNum;
                }
            }
            List<Integer> tt = new ArrayList<>(layer);
            res.add(tt);
            layer.clear();
            num = nextNum;   // 更新
            nextNum = 0;
        }
        return res;
    }
}
