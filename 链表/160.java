// 两个指针分别遍历链表A和B，A指针走到结尾时回到B的头，B走到结尾回到A的头。两个指针会在交点处相遇
// 证明：设链表A交点前有a个节点，交点后有b个节点。链表B交点前有c个节点，后有d个节点（b == d）
// 相遇时A走过的路程为a+b+c+1，B走过的路程为c+d+1+a = a+b+c+1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int tailA = 0, tailB = 0;
        boolean tailAA = false, tailBB = false;
        while (p1 != p2) {
            if (p1.next == null) {
                tailA = p1.val;
                tailAA = true;
                if (tailBB && tailA != tailB) {
                    return null;
                }
            }
            if (p2.next == null) {
                tailB = p2.val;
                tailBB = true;
                if (tailAA && tailA != tailB) {
                    return null;
                }
            }
            if (p1 != null && p2 != null) {
                p1 = p1.next; 
                p2 = p2.next;
            }
            if (p1 == null) {
                p1 = headB;
            }
            if (p2 == null) {
                p2 = headA;
            }
        }
        return p1;
    }
}
