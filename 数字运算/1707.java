// 用字典树存储所有数字，每个节点两个孩子，代表下一位是0还是1。一个叶子节点是一个数字
// 每个节点存储min，代表以这个节点为根的子树的最小值，若这个值 > limit，不用考虑这颗子树
// 为了计算最大异或结果，要让结果中出现尽可能多的1。若数字的这一位是0，则要与这一位是1的数字异或
class Trie {
    static final int len = 30;
    public Trie[] child = new Trie[2];
    public int min = Integer.MAX_VALUE;
    public void insert(int x) {
        Trie node = this;
        node.min = Math.min(node.min, x);
        // 从高位到低位
        for (int i = len - 1; i >= 0; --i) {
            int bit = (x >> i) & 1;   // 这一位是0还是1
            if (node.child[bit] == null) {
                node.child[bit] = new Trie();
            }
            node = node.child[bit];
            node.min = Math.min(node.min, x);
        }
    }

    public int getResult(int x, int limit) {
        Trie node = this;
        if (node.min > limit) {
            return -1;
        }
        int res = 0;
        for (int i = len - 1; i >= 0; --i) {
            int bit = (x >> i) & 1;
            // 找与这一位相反的数字，同时要求min <= limit
            if (node.child[bit ^ 1] != null && node.child[bit ^ 1].min <= limit) {
                res |= (1 << i);   // 结果的这一位是1，否则是0
                bit ^= 1;
            }
            node = node.child[bit];
        }
        return res;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie tree = new Trie();
        for (int i : nums) {
            tree.insert(i);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            res[i] = tree.getResult(queries[i][0], queries[i][1]);
        }
        return res;
    }
}
