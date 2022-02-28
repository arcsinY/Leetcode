class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || n == 1){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        // cur 是第 m 个节点，pre 是 m-1 个
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
            pre = pre.next;
            n--;
        }
        ListNode subHead = pre;   // 反转部分的前一个节点，反转之后这个节点连到 n
        ListNode subTail = cur;   // 第 m 个节点，反转之后这个节点连接到 n+1 上
        ListNode t = null;
        while (n > 0) {
            t = cur.next;   // 保留 cur 的下一个，否则指针无法前进
            cur.next = pre; // 反转 cur 和 pre
            pre = cur;      // pre 前进
            cur = t;        // cur 前进
            n--;
        }  // 循环结束后 cur 指向 n+1，pre 指向 n
        // 完成最后两步
        // subHead 不是真正链表中的节点，说明链表前一部分都被反转了，直接令反转后的头部（pre）作为 head
        if(subHead.val != -1){
            subHead.next = pre;
        } else{
            head = pre;
        }
        subTail.next = cur;
        return head;
    }
}
