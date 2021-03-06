// 构件图：每个单词作为一个顶点，能够互相转换的单词作为边。
// 从beginWord开始进行BFS，第一次遍历到endWord的距离为最短转换距离
// 为了更好判断两个单词是否能互相转换，添加虚拟顶点。若一单词为“abc”，则添加3个顶点"a*c", "*bc", "ab*"，将"abc"与这三个顶点相连。
// 这样可互相转换的两个单词是2-hop关系
class Solution {
    HashMap<String, Integer> word2Id = new HashMap<>();   // 单词--顶点id
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();   // 邻接表
    int wordId = 0;
  
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String i : wordList) {
            addVertexAndEdge(i);
        }
        addVertexAndEdge(beginWord);
        if (word2Id.containsKey(endWord) == false) {
            return 0;
        }
        // 从beginWord到每一个顶点的距离 
        int[] dis = new int[word2Id.size()];
        // 距离初始化为最大值。不需要visit数组，因为距离==Integer.MAX_VALUE说明没访问过
        Arrays.fill(dis, Integer.MAX_VALUE);
        Deque<Integer> q = new LinkedList<>();
        int beginId = word2Id.get(beginWord);
        int endId = word2Id.get(endWord);
        q.offer(beginId);
        dis[beginId] = 0;
        while (q.isEmpty() == false) {
            int id = q.poll();
            // 找到endWord，结束
            if (id == endId) {
                // 因为可互相转换的节点是2-hop相邻的，因此距离/2。
                // 要求的是路径上的顶点数量，包含beginWord，因此结果+1
                return dis[id] / 2 + 1;
            }
            for (int i = 0; i < adjList.get(id).size(); ++i) {
                int t = adjList.get(id).get(i);
                if (dis[t] == Integer.MAX_VALUE) {
                    dis[t] = dis[id] + 1;
                    q.offer(t);
                }
            }
        }
        return 0;
    }
  
    // 添加一个单词和虚拟节点，添加它们之间的边
    public void addVertexAndEdge(String word) {
        addVertex(word);
        int id1 = word2Id.get(word);
        char[] wordArr = word.toCharArray();
        // 将单词每个位置换为*
        for (int i = 0; i < wordArr.length; ++i) {
            char temp = wordArr[i];
            wordArr[i] = '*';
            String newWord = new String(wordArr);
            addVertex(newWord);
            int id2 = word2Id.get(newWord);
            adjList.get(id1).add(id2);
            adjList.get(id2).add(id1);
            wordArr[i] = temp;
        }
    }
  
    // 将一个单词加入map中
    public void addVertex(String word) {
        if (word2Id.containsKey(word) == false) {
            word2Id.put(word, wordId++);
            adjList.add(new ArrayList<Integer>());
        }
    }
}
