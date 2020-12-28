class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p1 = pre;
        ListNode p2 = head;
        //p2可能在里面的while循环中直接跳到空，所以既要判断p2!=null又要判断p2.next != null
        while(p2 != null && p2.next != null) {
            if(p1.next.val != p2.next.val) {
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                while(p2.next != null && p2.next.val == p1.next.val)   //跳过重复的
                    p2 = p2.next;
                p1.next = p2.next;
                p2 = p2.next;
            }
        }
        return pre.next;
    }
}
