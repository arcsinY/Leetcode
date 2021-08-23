// 用变量slot表示二叉树中能出现的最大节点数
// 当遇到#时，将slot + 1，表示加进了一个节点，但节点总数没有变化
// 遇到数字时，将slot + 1，表示加进了一个节点，但同时能够多两个节点
func isValidSerialization(preorder string) bool {
    slot := 1
    n := len(preorder)
    for i := 0; i < n; i++ {
        if slot == 0 {
            return false
        } else if preorder[i] == ',' {
            continue
        } else if preorder[i] == '#' {
            slot--
        } else {
            for i < n && preorder[i] != ',' {
                i++
            }
            slot++
            i--
        }
    }
    return slot == 0
}
