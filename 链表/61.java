class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode newHead = head;
        ListNode newTail = head;
        // 链表长度
        int n = 0;
        while(head.next !=null)  //链表形成环，计算长度
        {
            ++n;
            head = head.next;
        }
        ++n;
        head.next = newHead;
        ListNode t = newHead;
        for(int i = 1;i <= n- k%n; i++)  //找新链表的尾部
        {
            t = t.next;
        }
        newTail = t;
        newHead = t.next;
        t.next = null;
        return newHead;
    }
}
