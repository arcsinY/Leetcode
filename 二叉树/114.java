// 当前处理的节点是cur，cur在链表中的下一个节点一定是cur.left
// cur的右子树一定全部在cur.left的最右子树之后
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        TreeNode mostRight;
        TreeNode next;
        while(cur != null) {
            if (cur.left != null) {
                next = cur.left;   // 下一个节点
                mostRight = cur.left;
                while (mostRight.right != null) {   // 找左孩子的最右孩子
                    mostRight = mostRight.right;
                }
                mostRight.right = cur.right;    // cur的右子树接在最右孩子之后
                // 设定cur的最右孩子
                cur.left = null;   
                cur.right = next;  
            }
            // 处理下一个
            cur = cur.right;
        }
    }
}
