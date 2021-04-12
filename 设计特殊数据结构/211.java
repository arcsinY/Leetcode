class TierNode {
    private TierNode[] child;
    private boolean end;
    public TierNode() {
        child = new TierNode[26];
    }
    public void addChild(char c) {
        child[c - 'a'] = new TierNode();
    }
    public TierNode getChild(char c) {
        return child[c - 'a'];
    }
    public TierNode getChild(int i) {
        return child[i];
    }
    public boolean getEnd() {
        return end;
    }
    public void setEnd() {
        end = true;
    }
}

class WordDictionary {
    TierNode root;
    public WordDictionary() {
        root = new TierNode();
    }

    public void addWord(String word) {
        TierNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.getChild(c) == null) {
                node.addChild(c);
            }
            node = node.getChild(c);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return dfs(word, root);
    }
    public boolean dfs(String word, TierNode root) {
        TierNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            // 这个字符可以匹配任何字符，因此遍历当前节点所有的子树进行搜索
            if (c == '.') {
                for (int j = 0; j < 26; ++j) {
                    // 按下标取出孩子节点，不按字符，因为"."不是英文字母
                    if (node.getChild(j) != null) {
                        // 有一个子树能匹配剩余的字符，返回true
                        if (dfs(word.substring(i + 1), node.getChild(j))) {
                            return true;
                        }
                    }
                }
                // 都不能匹配，false
                return false;
            }
            node = node.getChild(c);
            if (node == null) {
                return false;
            }
        }
        return node.getEnd();
    }
}
