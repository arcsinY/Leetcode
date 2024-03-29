// 寻找中间节点+反转链表+链表合并
// 第二个链表的头节点是中间节点之后的一个节点
// 链表合并要保存下一个节点
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = mid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        ListNode p1 = head;
        ListNode p2 = head2;
        ListNode p1Next;
        ListNode p2Next;
        while (p1 != null && p2 != null) {
            p1Next = p1.next;
            p2Next = p2.next;
            p1.next = p2;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
    }
    ListNode mid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
