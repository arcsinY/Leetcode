// 每次选出最小的节点作为当前节点，用优先队列维护所有链表中的当前最小节点
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        for (ListNode i : lists) {
            if (i != null) {
                pq.add(i);
            }
        }
        while (pq.isEmpty() == false) {
            ListNode t = pq.poll();
            p.next = t;
            if (t.next != null) {
                pq.add(t.next);
            }
            p = p.next;
        }
        return preHead.next;
    }
}
