class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
