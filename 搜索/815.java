// 图：每个路线是一个顶点，路线之间有公共车站是一条边。包含source的路线是起点，包含target的车站是终点
// BFS：初始时有多个点加入队列，最后也有多个终点，取最小值
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source ==  target) {
            return 0;
        }
        int n = routes.length;
        int ans = Integer.MAX_VALUE;
        List<List<Integer>> adjList = new ArrayList<>();   // 邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();  // 记录每个车站都有哪些路线能到
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }
        // 构造map
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < routes[i].length; ++j) {
                int station = routes[i][j];
                if (map.containsKey(station)) {
                    map.get(station).add(i);
                } else {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    map.put(station, t);
                }
            }
        }
        // 构建图
        for (int i : map.keySet()) {
            List<Integer> list = map.get(i);
            for (int j = 0 ; j < list.size(); ++j) {
                for (int k = j + 1; k < list.size(); ++k) {
                    int route1 = list.get(j);
                    int route2 = list.get(k);
                    adjList.get(route1).add(route2);
                    adjList.get(route2).add(route1);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // dist可以作为visit使用，dist[i] == -1说明没有访问过
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        // 多个起点
        for (int i = 0; i < map.get(source).size(); ++i) {
            q.add(map.get(source).get(i));
            dist[map.get(source).get(i)] = 1;
        }
        while (q.isEmpty() == false) {
            int t = q.poll();
            // 能够跟t换乘的路线
            for (int i = 0; i < adjList.get(t).size(); ++i) {
                int s = adjList.get(t).get(i);
                if (dist[s] == -1) {
                    dist[s] = dist[t] + 1;
                    q.add(s);
                }
            }
        }
        for (int i = 0; i < map.get(target).size(); ++i) {
            int t = map.get(target).get(i);
            if (dist[t] != -1) {
                ans = Math.min(ans, dist[t]);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
