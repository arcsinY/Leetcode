public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        // cur 是已经确定的链表部分的最后一个节点
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            // 这个节点值只出现一次，保留
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                // 所有 val == x 的节点都要删除
                // cur.next 是第一个 val != x 的节点
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }
        }
        return pre.next;
    }
}
