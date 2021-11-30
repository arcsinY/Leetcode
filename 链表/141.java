// 基本方法：访问一个节点加入set中，每次判断一个节点是否访问过，空间复杂度O(n)
// 弗洛伊德判圈方法：快慢指针，快指针每次走两步，慢指针一步。若快指针走到结束说明没有环。某一时刻快指针 == 慢指针说明有环（套了一圈）
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != p2) {
            if (p2 == null || p2.next == null) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }
}
