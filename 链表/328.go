// 遍历链表的过程中将链表拆分为奇偶两个链表
func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
  // 偶链表的头节点
	evenHead := head.Next
  // even在odd的后面一个位置
	odd := head
	even := evenHead
	for even != nil && even.Next != nil {
    // 隔一个取节点
		odd.Next = even.Next
		odd = odd.Next
		even.Next = odd.Next
		even = even.Next
	}
	odd.Next = evenHead
	return head
}
