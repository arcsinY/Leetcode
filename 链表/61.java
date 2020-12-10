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
        int n=0;
        while(head.next !=null)  //链表形成环，计算长度
        {
            ++n;
            head = head.next;
        }
        ++n;
        head.next = newHead;
        ListNode t = newHead;
        for(int i=0;i<n-k%n-1;++i)  //找新链表的尾部
        {
            t = t.next;
        }
        newTail = t;
        newHead = t.next;
        t.next = null;
        return newHead;
    }
}