// 用栈存储一层中的节点，不能使用队列
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(pRoot);
        boolean left = false;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> one = new ArrayList<>();
            // 由于出栈入栈都在同一端，因此下一层的节点要用另一个栈存储，不能直接加载当前栈中
            Deque<TreeNode> next = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.removeLast();
                one.add(t.val);
                if (!left) {
                    if (t.left != null) {
                        next.addLast(t.left);
                    }
                    if (t.right != null) {
                        next.addLast(t.right);
                    }
                } else {
                    if (t.right != null) {
                        next.addLast(t.right);
                    }
                    if (t.left != null) {
                        next.addLast(t.left);
                    }
                }
            }
            ans.add(one);
            left = !left;
            q = next;
        }
        return ans;
    }

}
