// 如果使用层次遍历，空间复杂度为O(n)，要求空间复杂度为O(1)
// 当前指针在第n层时，处理第(n+1)层节点的连接。共有两种连接：
// 1. 左孩子和右孩子的的连接
// 2. 右孩子和next的左孩子的连接
// 记录一层最左的节点，需要访问下一层时，可直接访问这个节点的左孩子。因为是完全二叉树，这个节点为null时停止迭代
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        Node leftMost = root;
        while(leftMost.left != null) {   // 停止条件
            Node layerHead = leftMost;    // 用于遍历当前层的指针
            while (layerHead != null) {  // 遍历当前层（链表遍历）
                layerHead.left.next = layerHead.right;  //第1种连接
                if (layerHead.next != null) {      // 第2种连接
                    layerHead.right.next = layerHead.next.left;
                }
                layerHead = layerHead.next;    // 当前层的下一个
            }
            leftMost = leftMost.left;   // 下一层
        }
        return root;
    }
}
