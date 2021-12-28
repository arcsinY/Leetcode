class TrieNode {
    private TrieNode[] child;
    private final int R = 26;
    boolean end;
    public TrieNode() {
        child = new TrieNode[R];
    }
    public TrieNode getChar(char c) {
        return child[c - 'a'];
    }
    public void add(char c) {
        child[c - 'a'] = new TrieNode();
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
            char c = word.charAt(i);
            if (node.getChar(c) == null) {
                node.add(c);
            }
            node = node.getChar(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (node.getChar(c) == null) {
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
            if (node.getChar(c) == null) {
                return false;
            }
            node = node.getChar(c);
        }
        return true;
    }
}
