// 基本方法：访问一个节点加入set中，每次判断一个节点是否访问过，空间复杂度O(n)
// 弗洛伊德判圈方法：快慢指针，快指针每次走两步，慢指针一步。若快指针走到结束说明没有环。某一时刻快指针 == 慢指针说明有环（套了一圈）
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
