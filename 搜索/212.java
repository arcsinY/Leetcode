import java.util.*;
// 可以使用Trie树判断有无包含某个前缀的字符串
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        Set<String> resSet = new HashSet<>();
        int m = board.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = board[0].length;
        int maxLength = 0;
        for (String i: words) {
            set.add(i);
            if (i.length() > maxLength) {
                maxLength = i.length();
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean[][] used = new boolean[m][n];
                used[i][j] = true;
                StringBuilder one = new StringBuilder();
                dfs(board, resSet, one, set, 1, maxLength, i, j, used, m, n);
            }
        }
        return new ArrayList<>(resSet);
    }
    public void dfs(char[][] board, Set<String> res, StringBuilder one, Set<String> set, int len, int maxLength, int i, int j, boolean[][] used, int m, int n) {
        one.append(board[i][j]);
        if (set.contains(one.toString())) {
            res.add(one.toString());
        }
        if (len >= maxLength) {
            return;
        }
        if (i > 0 && used[i - 1][j] == false) {
            used[i - 1][j] = true;
            dfs(board, res, one, set, len + 1, maxLength, i - 1, j, used, m, n);
            one.deleteCharAt(one.length() - 1);
            used[i - 1][j] = false;
        }
        if (i < m - 1 && used[i + 1][j] == false) {
            used[i + 1][j] = true;
            dfs(board, res, one, set , len + 1, maxLength, i + 1, j, used, m, n);
            one.deleteCharAt(one.length() - 1);
            used[i + 1][j] = false;
        }
        if (j > 0 && used[i][j - 1] == false) {
            used[i][j - 1] = true;
            dfs(board, res, one, set , len + 1, maxLength, i, j - 1, used, m, n);
            one.deleteCharAt(one.length() - 1);
            used[i][j - 1] = false;
        }
        if (j < n - 1 && used[i][j + 1] == false) {
            used[i][j + 1] = true;
            dfs(board, res, one, set , len + 1, maxLength, i, j + 1, used, m, n);
            one.deleteCharAt(one.length() - 1);
            used[i][j + 1] = false;
        }
    }
}
