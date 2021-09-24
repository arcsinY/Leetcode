// 遇到child就递归到下一层，将下一层的链表插入到上一层的两个节点之间
class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    public Node dfs(Node head) {
        // 这一层链表的最后一个节点
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node t = head.next;
                // 得到下面层的链表
                Node childLast = dfs(head.child);
                // 插入到head和head.next之间
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) {
                    childLast.next = t;
                }
                if (t != null) {
                    t.prev = childLast;
                }
                last = head;
                head = childLast;
            }
        }
        return last;
    }
}
