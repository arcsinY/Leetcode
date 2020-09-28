class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode temp=pre;
        while(temp.next != null && temp.next.next != null)
        {
            ListNode first=temp.next;
            ListNode second = temp.next.next;
            temp.next=second;
            first.next=second.next;
            second.next=first;
            temp=first;
        }
        return pre.next;
    }
}
