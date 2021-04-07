// 拓扑排序，判断图是否有环
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();   // 邻接表
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<>());
        }
        int[] deg = new int[numCourses];   // 顶点的入度
        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
            deg[a]++;
        }
        // 将入度 = 0的点加入队列，删除
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (q.isEmpty() == false) {
            int u = q.poll();
            --numCourses;
            for (int i = 0; i < adjList.get(u).size(); ++i) {
                int v = adjList.get(u).get(i);
                deg[v]--;
                if (deg[v] == 0) {
                    q.add(v);
                }
            }
        }
        if (numCourses == 0) {
            return true;
        }
        return false;
    }
}


