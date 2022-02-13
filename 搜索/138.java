class Solution {
    // 存储旧节点和新节点的对应关系
    Map<Node, Node> map = new HashMap<>();
    // 复制旧节点 head， 返回复制后的新节点
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        // 复制这个节点的值
        Node node = new Node(head.val);
        map.put(head, node);
        // 复制 next 节点
        node.next = copyRandomList(head.next);
        // 复制 random 节点
        node.random = copyRandomList(head.random);
        return node;
    }
}
