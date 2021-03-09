// 首先将长度为1的子链表两两归并，下一次将长度为2的两两归并，……，直到长度为length/2的两两归并
// 时间复杂度O(nlogn)
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head;
        int length = 0;
        while (t != null) {
            t = t.next;
            ++length;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        // 长度为i的子链表两两归并
        for (int i = 1; i < length; i *= 2) {
            // aHead：已经排序的部分的最后一个节点
            ListNode aHead = preHead;
            // cur：头节点
            ListNode cur = preHead.next;
            while (cur != null) {
                ListNode next = cur;
                // h1：要归并的第一个链表的头节点
                ListNode h1 = cur;
                for (int j = 1; j < i && cur != null; ++j) {
                    cur = cur.next;
                }
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                    cur = next;
                }
                // h2：要归并的第二个链表的头节点
                ListNode h2 = cur;
                for (int j = 1; j < i && cur != null; ++j) {
                    cur = cur.next;
                }
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                    cur = next;
                }
                aHead.next = merge(h1, h2);
                while (aHead.next != null) {
                    aHead = aHead.next;
                }
            }
        }
        return preHead.next;
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode preHead = new ListNode();
        preHead.next = null;
        ListNode cur = preHead;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return preHead.next;
    }
}
