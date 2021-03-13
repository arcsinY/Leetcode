import java.util.*;

class Solution {
    Map<String, Integer> wordId = new HashMap<>();
    List<String> idWord = new ArrayList<>();
    List<Integer>[] edge;
    int num = 0;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 构建图
        for (String i : wordList) {
            addVertex(i);
        }
        if (wordId.containsKey(endWord) == false) {
            return new ArrayList<>();
        }
        addVertex(beginWord);
        edge = new ArrayList[idWord.size()];
        for (int i = 0; i < edge.length; ++i) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 0; i < idWord.size(); ++i) {
            for (int j = i + 1; j < idWord.size(); ++j) {
                if (transform(idWord.get(i), idWord.get(j))) {
                    edge[i].add(j);
                    edge[j].add(i);
                }
            }
        }
        // 结果
        List<List<String>> res = new ArrayList<>();
        // 搜索到的路径 
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        int start = wordId.get(beginWord);
        int end = wordId.get(endWord);
        temp.add(start);
        q.add(temp);
        // cost[i]: 从开始点到i的路径长度
        int[] cost = new int[wordId.size()];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        while (q.isEmpty() == false) {
            // 一条路径
            List<Integer> now = q.poll();
            int nowId = now.get(now.size() - 1);
            // 到达终点，搜索过程中保证路径是最短的
            if (nowId == end) {
                ArrayList<String> t = new ArrayList<>();
                for (int i : now) {
                    t.add(idWord.get(i));
                }
                res.add(t);
            } else {
                for (int i = 0; i < edge[nowId].size(); ++i) {
                    int id = edge[nowId].get(i);
                    if (cost[nowId] + 1 <= cost[id]) {
                        cost[id] = cost[nowId] + 1;
                        ArrayList<Integer> t = new ArrayList<>(now);
                        t.add(id);
                        q.add(t);
                    }
                }
            }
        }
        return res;
    }
    public void addVertex(String word) {
        if (wordId.containsKey(word) == false) {
            wordId.put(word, num++);
            idWord.add(word);
        }
    }
    public boolean transform(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++diff;
            }
        }
        if (diff != 1) {
            return false;
        }
        return true;
    }
}
