import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || n == 1){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        //cur是第m个节点，pre是m-1个
        while(m > 1){
            pre = pre.next;
            cur = cur.next;
            --m;
            --n;
        }
        ListNode subHead = pre;   //反转部分的前一个节点，反转之后这个节点连到n
        ListNode subTail = cur;   //第m个节点，反转之后这个节点连接到n+1上
        ListNode t = null;
        while(n > 0){
            t = cur.next;   //保留cur的下一个，否则指针无法前进
            cur.next = pre;   //反转cur和pre
            pre = cur;  //pre前进
            cur = t;    //cur前进
            --n;
        }   //循环结束后cur指向n+1，pre指向n
        //完成最后两步
        //subHead不是真正链表中的节点，说明链表前一部分都被反转了，直接令反转后的头部（pre）作为head
        if(subHead.val != -1){
            subHead.next = pre;
        } else{
            head = pre;
        }
        subTail.next = cur;
        return head;
    }
}
