import java.util.LinkedList;
import java.util.Queue;
// 输入是按照层次遍历的输入，因此对两棵树进行层次遍历，逐个元素比较，有不一样的返回false。最终两个队列同时为空返回true
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
        while (pQueue.isEmpty() == false && qQueue.isEmpty() == false) {
            TreeNode t1 = pQueue.poll();
            TreeNode t2 = qQueue.poll();
            // 两个节点都不空，比较值，将左右孩子加入队列
            if (t1 != null && t2 != null) {
                if (t1.val == t2.val) {
                    pQueue.add(t1.left);
                    pQueue.add(t1.right);
                    qQueue.add(t2.left);
                    qQueue.add(t2.right);
                    continue;
                } else {
                    return false;
                }
            }
            // 节点同时为空，可以继续比较
            if (t1 == null && t2 == null) {
                continue;
            } else {
                return false;
            }
        }
        // 最终队列同时为空返回true，否则false
        if (pQueue.isEmpty() == true && qQueue.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }
}
