// dfs：start开始拆分字符串。从头开始遍历字符串，得到一个在字典中的单词后递归调用dfs拆分后面的字符串
// 会导致从某一位置开始的拆分结果重复计算，因此用记忆化搜索
// 用Map存储从某一位置开始的拆分结果
class Solution {
    Set<String> dict = new HashSet<>();   // 用Set存储所有的单词，加快判断速度
    Map<Integer, List<List<String>>> mem = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String i : wordDict) {
            dict.add(i);
        }
        List<List<String>> allRes = new LinkedList<>();
        allRes = dfs(s, wordDict, 0);
        List<String> res = new LinkedList<>();
        for (int i = 0; i < allRes.size(); ++i) {
            res.add(String.join(" ", allRes.get(i)));
        }
        return res;
    }
    // 这里的每个句子没加空格，一个句子用List<String>表示，拆分结果为多个句子
    List<List<String>> dfs(String s, List<String> wordDict, int start) {
        // 递归出口，返回一个句子，包含一个空列表
        if (start == s.length()) {
            List<List<String>> t = new LinkedList<>();
            t.add(new LinkedList<>());
            return t;
        }
        if (mem.containsKey(start)) {
            return mem.get(start);
        }
        List<List<String>> allRes = new LinkedList<>();
        for (int i = start + 1; i <= s.length(); ++i) {
            String sub = s.substring(start, i);
            if (dict.contains(sub)) {
                List<List<String>> nextAllRes = dfs(s, wordDict, i);
                // 后面拆分出的每个句子，都加上当前这个单词，组成新的句子 
                for (int j = 0; j < nextAllRes.size(); ++j) {
                    List<String> t = new LinkedList<>(nextAllRes.get(j));
                    t.add(0, sub);
                    allRes.add(t);
                }
            }
        }
        mem.put(start, allRes);
        return allRes;
    }
}
