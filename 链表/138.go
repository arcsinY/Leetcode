// 在每个节点后面加一个新节点，新节点就是复制出来的节点。
// 这样新节点的random就是前面节点的random的next
// 最后将所有新节点提取出来组成链表
func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	for node := head; node != nil; node = node.Next.Next {
		t := node.Next
		node.Next = new(Node)
		node.Next.Val = node.Val
		node.Next.Next = t
	}
	for node := head; node != nil; node = node.Next.Next {
		if node.Random != nil {
			node.Next.Random = node.Random.Next
		}
	}
	ans := head.Next
	for node := head; node != nil; node = node.Next {
    	// 提取新节点
		newNode := node.Next
		node.Next = node.Next.Next
		if newNode.Next != nil {
      			// 新节点的下一个节点
			newNode.Next = newNode.Next.Next
		}
	}
	return ans
}
