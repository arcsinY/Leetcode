// 一种计数值的节点，包含所有次数 == cnt 的 key
type LNode struct {
	Set  map[string]struct{}
	Cnt  int
	Prev *LNode
	Next *LNode
}

// 思路：先根据 M 找出 key 的节点。判断其后一个节点的 cnt 是否等于 cnt + 1（Inc 操作）
// 如果是，则将 key 加入到后面的节点中。否则在后面单独创建一个计数值为 cnt + 1 的节点
type AllOne struct {
	M    map[string]*LNode
	Head *LNode
	Tail *LNode
}


func Constructor() AllOne {
	ans := AllOne{}
	ans.M = make(map[string]*LNode)
	ans.Head = new(LNode)
	ans.Tail = new(LNode)
	ans.Head.Cnt = -1
	ans.Tail.Cnt = -1
	ans.Head.Next = ans.Tail
	ans.Tail.Prev = ans.Head
	return ans
}

// 在 prev 之后插入新节点，设置新节点的 cnt 和一个 key
func NewNodeAfter(prev *LNode, cnt int, key string) *LNode {
	newNode := new(LNode)
	newNode.Cnt = cnt
	newNode.Set = make(map[string]struct{})
	newNode.Set[key] = struct{}{}
	newNode.Next = prev.Next
	newNode.Prev = prev
	prev.Next.Prev = newNode
	prev.Next = newNode
	return newNode
}

// 在 next 之前插入新节点，设置新节点的 cnt 和一个 key
func NewNodeBefore(next *LNode, cnt int, key string) *LNode {
	newNode := new(LNode)
	newNode.Cnt = cnt
	newNode.Set = make(map[string]struct{})
	newNode.Set[key] = struct{}{}
	newNode.Next = next
	newNode.Prev = next.Prev
	next.Prev.Next = newNode
	next.Prev = newNode
	return newNode
}

func (this *AllOne) Inc(key string)  {
	node, ok := this.M[key]
	var newNode *LNode
  // key 已存在
	if ok {
		if node.Next.Cnt == node.Cnt + 1 {
			node.Next.Set[key] = struct{}{}
			newNode = node.Next
		} else {
			newNode = NewNodeAfter(node, node.Cnt + 1, key)
		}
		delete(node.Set, key)
		if len(node.Set) == 0 {
			node.Prev.Next = node.Next
			node.Next.Prev = node.Prev
		}
	} else {
    // key 不存在，在 head 后面创建一个 cnt == 1 的节点
		node2 := this.Head.Next
		if node2.Cnt == 1 {
			node2.Set[key] = struct{}{}
			newNode = node2
		} else {
			newNode = NewNodeAfter(this.Head, 1, key)
		}
	}
	this.M[key] = newNode
}


func (this *AllOne) Dec(key string)  {
	node, _ := this.M[key]
	var newNode *LNode
  // 这个 key 直接被删除，不移动到其它 node 中
	if node.Cnt == 1 {
		delete(node.Set, key)
		delete(this.M, key)
		if len(node.Set) == 0 {
			node.Prev.Next = node.Next
			node.Next.Prev = node.Prev
		}
		return
	}
  // 前一个节点的 cnt
	if node.Prev.Cnt == node.Cnt - 1 {
		node.Prev.Set[key] = struct{}{}
		newNode = node.Prev
	} else {
		newNode = NewNodeBefore(node, node.Cnt - 1, key)
	}
	delete(node.Set, key)
	if len(node.Set) == 0 {
		node.Prev.Next = node.Next
		node.Next.Prev = node.Prev
	}
	this.M[key] = newNode
}


func (this *AllOne) GetMaxKey() string {
	maxNode := this.Tail.Prev
	if maxNode == this.Head {
		return ""
	}
	for k, _ := range maxNode.Set {
		return k
	}
	return ""
}


func (this *AllOne) GetMinKey() string {
	minNode := this.Head.Next
	if minNode == this.Tail {
		return ""
	}
	for k, _ := range minNode.Set {
		return k
	}
	return ""
}
