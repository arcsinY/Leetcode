// 与116题相比，下一层的首节点不知道从哪里开始，因此对于下一层设立一个冗余节点nxtLayerHead
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        Node thisLayer = root;  // 这一层的节点
        while (thisLayer != null) {
            Node nxtLayerHead = new Node();   // 下一层的冗余节点
            Node nxtLayer = nxtLayerHead;    // 下一层用于添加指针的节点
            while (thisLayer != null) {   // 遍历这一层
                if (thisLayer.left != null) {   // 不是完全二叉树，因此每一个节点都要判断null
                    nxtLayer.next = thisLayer.left;
                    nxtLayer = nxtLayer.next;
                }
                if (thisLayer.right != null) {
                    nxtLayer.next = thisLayer.right;
                    nxtLayer = nxtLayer.next;
                }
                thisLayer = thisLayer.next;
            }
            thisLayer = nxtLayerHead.next;
        }
        return root;
    }
}
