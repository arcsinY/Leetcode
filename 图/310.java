// 可以遍历所有顶点，作BFS，计算以这个点为根的树高度，但会超时
// 从图的外围遍历到中心，中心作为根的树高度最小
// 每次取度 == 1的顶点，这是图的最外围，向内层做BFS
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<Integer>(Arrays.asList(0));
        }
        List<List<Integer>> adjList = new ArrayList<>(n);
        int[] deg = new int[n];
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            int a = i[0];
            int b = i[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
            ++deg[a];
            ++deg[b];
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (deg[i] == 1) {
                q.add(i);
            }
        }
        List<Integer> ans = null;
        while (q.isEmpty() == false) {
            ans = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int t = q.poll();
                vis[t] = true;
                // 当前最外围的节点直接加入结果中，但每次循环ans都是一个新的数组，因此直到最后一次BFS才会加入真正的结果
                ans.add(t);
                for (int j = 0; j < adjList.get(t).size(); ++j) {
                    int t2 = adjList.get(t).get(j);
                    if (vis[t2]) {
                        continue;
                    }
                    --deg[t2];
                    if (deg[t2] == 1) {
                        q.add(t2);
                    }
                }
            }
        }
        return ans;
    }
}
