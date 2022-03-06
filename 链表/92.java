class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = preHead;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        ListNode next = cur.next;
        // 反转部分的前一个节点
        ListNode subHead = pre;
        // 反转部分的第一个节点
        ListNode subTail = cur;
        // 反转之后，pre 是反转部分的最后一个节点，cur 是反转部分的之后一个节点
        for (int i = 0; i <= right - left; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        subHead.next = pre;
        subTail.next = cur;
        return preHead.next;
    }
}
