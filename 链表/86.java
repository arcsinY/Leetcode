class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode smallHead = new ListNode(-1);
        ListNode pSmall = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode pBig = bigHead;
        while(p != null) {
            if(p.val < x) {
                ListNode t = new ListNode(p.val);
                pSmall.next = t;
                pSmall = pSmall.next;
            }
            else {
                ListNode t = new ListNode(p.val);
                pBig.next = t;
                pBig = pBig.next;
            }
            p = p.next;
        }
        pSmall.next = bigHead.next;
        pBig.next = null;
        return smallHead.next;
    }
}
