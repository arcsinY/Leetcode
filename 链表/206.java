// 遍历所有节点，修改next元素为前一节点，因此要保存前一节点的指针。同时保存后一节点的指针，用于指针后移
// 用cur指向当前要处理的节点，pre指向前一个节点，nxt指向后一节点
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;  // 头节点的后一指针要修改为null
        ListNode cur = head;
        ListNode nxt = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {  // cur走到最后时，nxt==null，这时不能继续移动nxt
                nxt = nxt.next;
            }
        }
        return pre;
    }
}
