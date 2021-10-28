// 判断二分图：从每个顶点开始做dfs，遍历其相邻顶点
// 如果一个相邻点已经访问过了，判断其颜色是否与本节点颜色相同
// 如果没访问过，则将相邻点染色为与本顶点不同的颜色，递归
// 额外使用一个变量表示是否已经得到结果
class Solution {
    boolean[] vis;
    boolean[] color;
    boolean ok = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        vis = new boolean[n];
        color = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (vis[i] == false) {
                dfs(i, graph);
            }
        }
        return ok;
    }
    public void dfs(int u, int[][] graph) {
        if (ok == false) {
            return;
        }
        vis[u] = true;
        for (int i = 0; i < graph[u].length; ++i) {
            int v = graph[u][i];
            if (vis[v]) {
                if (color[v] == color[u]) {
                    ok = false;
                }
            } else {
                color[v] = !color[u];
                dfs(v, graph);
            }
        }
    }
}
