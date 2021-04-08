// 树的一个节点
class TrieNode {
    private TrieNode[] child;   // 孩子节点
    private final int R = 26;
    boolean end;
    public TrieNode() {
        child = new TrieNode[R];
    }
    // 查找有没有到连接下一层的字符c
    public boolean containsChar(char c) {
        if (child[c - 'a'] != null) {
            return true;
        }
        return false;
    }
    public TrieNode getChar(char c) {
        return child[c - 'a'];
    }
    // 添加下一层
    public void add(char c, TrieNode node) {
        child[c - 'a'] = node;
    }
    public boolean isEnd() {
        return end;
    }
    public void setEnd() {
        end = true;
    }
}
class Trie {
    private  TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char t = word.charAt(i);
            if (node.containsChar(t) == false) {
                node.add(t, new TrieNode());
            }
            node = node.getChar(t);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.containsChar(c) == false) {
                return false;
            }
            node = node.getChar(c);
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (node.containsChar(c) == false) {
                return false;
            }
            node = node.getChar(c);
        }
        return true;
    }
}
