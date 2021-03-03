class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        ListNode preHead = new ListNode();   // 在首节点之前增加一冗余节点，便于头部插入
        preHead.next = head;
        head.next = null;
        while (cur != null) {
            cur.next = null;
            ListNode t = preHead;   
            // 找到插入位置，t指向插入位置之前的一个节点
            while (t.next != null && t.next.val < cur.val) {
                t = t.next;
            }
            cur.next = t.next;
            t.next = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return preHead.next;
    }
}
