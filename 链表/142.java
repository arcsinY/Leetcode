// 快指针一次走两步，慢指针一次走一步，在环上某个位置相遇。若不相遇则没有环
// 设从头节点到入环点的距离为a，入环点到快慢指针相遇点距离为b，相遇点到入环点距离为c
// 相遇时快指针走过的距离为：a+b+n(b+c)，n为环上走的圈数。满指针走的距离为a+b。快指针走过两倍的满指针路程，因此 a+b+n(b+c) = a+(n+1)b+nc = 2(a+b)，因此 a = (n-1)b+nc = (n-1)(b+c)+c
// 上式说明指针相遇时用另一指针p从head开始走，每次走一步，slow也每次走一步，p和slow会在入环点相遇。p为所求
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    slow = slow.next;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }
}
