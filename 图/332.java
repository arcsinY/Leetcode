// Hierholzer算法计算欧拉路径
// 1. 从当前节点开始DFS
// 2. 走过一条路径则删除这条路径
// 3. 无法进行DFS的节点（出度 == 0的点）进栈
// 4. 按照元素的出栈顺最为最终结果
class Solution {
    // 优先队列保证先访问字典序小的
    Map<String, PriorityQueue<String>> adjList = new HashMap<>();
    // 用链表做栈，顺序进入链表，最后反转链表
    List<String> ans = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); ++i) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (adjList.containsKey(from) == false) {
                adjList.put(from, new PriorityQueue<String>());
            }
            adjList.get(from).offer(to);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String s) {
        // 有出度邻居则进行DFS
        while (adjList.containsKey(s) && adjList.get(s).size() > 0) {
            String t = adjList.get(s).poll();
            dfs(t);
        }
        // 没有出度邻居了，进栈
        ans.add(s);
    }
}
