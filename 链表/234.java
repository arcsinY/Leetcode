// 找到中间节点，反转链表后半部分。两个指针同时遍历前半部分和后半部分，若有一个节点值不一样，则返回false
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;    // 中间节点的前一个节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表长度为奇数，要跳过中间节点
        if (fast != null) {
            slow.next = reverse(slow.next);
            slow = slow.next;
        } else {   // 链表长度为偶数，pre链接反转后的后半部分
            slow = reverse(slow);
            pre.next = slow;
        }
        ListNode t = head;
        while (slow != null) {
            if (t.val != slow.val) {
                return false;
            }
            t = t.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        return pre;
    }
}
