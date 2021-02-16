import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// 使用深度优先搜索克隆图的每个顶点
// 在构建一个点的邻接表时，克隆其所有相邻点加入邻接表
class Solution {
    HashMap<Node, Node> vis = new HashMap<>();   // 记录一个顶点是否被克隆过，保存对应的克隆之后的顶点
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // 已经克隆过
        if (vis.containsKey(node)) {
            return vis.get(node);
        }
        // 没克隆过，创造一个新的顶点作为克隆点
        Node res = new Node(node.val, new ArrayList<>());
        vis.put(node, res);
        // 克隆所有相邻点
        for (int i = 0; i < node.neighbors.size(); ++i) {
            res.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return res;
    }
    
}
