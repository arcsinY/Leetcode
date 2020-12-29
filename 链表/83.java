class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null) {
            while(p2 != null && p2.val == p1.val)
                p2 = p2.next;
            p1.next = p2;
            if(p1 != null && p2 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
