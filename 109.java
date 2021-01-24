class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // p1是中间节点，作为树根，pre作为链表左半部分的最后节点，即p1的前一个节点
        ListNode p1 = head, pre = null, p2 = head;
        while(p2 != null && p2.next != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 在pre之后断开，得到左半部分
        pre.next = null;
        TreeNode root = new TreeNode(p1.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p1.next);
        return root;
    }
}
