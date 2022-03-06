class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        // 反转部分的前一个节点
        ListNode pre = preHead;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 剩下的部分不足 k 个
                if (tail == null) {
                    return preHead.next;
                }
            }
            // 反转部分的下一个节点
            ListNode nxt = tail.next;
            // 反转之后，反转部分的首节点是 tail，尾节点是 head
            reverse(head, tail);
            pre.next = tail;
            head.next = nxt;
            pre = head;
            head = pre.next;
        }
        return preHead.next;
    }
    // 反转 [a, b] 的部分链表
    public void reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a.next;
        ListNode bNext = b.next;
        while (cur != bNext) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
    }
}
