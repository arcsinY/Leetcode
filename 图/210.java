class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] res = new int[numCourses];
        int idx = 0;
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<>());
        }
        int[] deg = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
            deg[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (q.isEmpty() == false) {
            int u = q.poll();
            res[idx++] = u;
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
            return res;
        }
        return new int[]{};
    }
}


