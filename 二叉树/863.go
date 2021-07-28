// 用map记录每个节点的父结点，由于val唯一，可以使用val作为key
// 之后从target开始向下、向上搜索。为了避免走回头路，用from记录这一次搜索是从哪个节点过来的
var parent map[int]*TreeNode
var ans []int

func distanceK(root *TreeNode, target *TreeNode, k int) []int {
	parent = make(map[int]*TreeNode)
	findParent(root, parent)
	ans = make([]int, 0)
	findAns(target, nil, 0, k)
	return ans
}

func findParent(root *TreeNode, parent map[int]*TreeNode) {
	if root.Left != nil {
		parent[root.Left.Val] = root
		findParent(root.Left, parent)
	}
	if root.Right != nil {
		parent[root.Right.Val] = root
		findParent(root.Right, parent)
	}
}

func findAns(root *TreeNode, from *TreeNode, depth int, k int) {
	if root == nil {
		return
	}
	if depth == k {
		ans = append(ans, root.Val)
	}
	if root.Left != from {
		findAns(root.Left, root, depth + 1, k)
	}
	if root.Right != from {
		findAns(root.Right, root, depth + 1, k)
	}
	if parent[root.Val] != from {
		findAns(parent[root.Val], root, depth + 1, k)
	}
} 
