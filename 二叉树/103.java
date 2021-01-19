import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
// 用栈实现锯齿遍历，当前行和下一行分别考虑
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        int thisLayer = 1;
        int nextLayer = 0;
        boolean flag = false;  // ==false说明下一行要求从右到左的遍历
        q.push(root);
        while (q.isEmpty() == false) {
            Deque<TreeNode> next = new LinkedList<>();   // 下一行的节点
            while (q.isEmpty() == false) {   // 遍历这一行
                TreeNode t = q.pop();
                one.add(t.val);
                if (flag == false) {   // 从右到左，先加左孩子，后右孩子
                    if (t.left != null) {
                        next.push(t.left);
                    }
                    if (t.right != null) {
                        next.push(t.right);
                    }
                } else {
                    if (t.right != null) {
                        next.push(t.right);
                    }
                    if (t.left != null) {
                        next.push(t.left);
                    }
                }

            }
            ArrayList<Integer> tt = new ArrayList<>(one);
            res.add(tt);
            one.clear();
            q = next;
            flag = !flag;
        }
        return res;
    }

}
