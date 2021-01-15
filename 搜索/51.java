import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> res = new ArrayList<>();
        List<String> one = new ArrayList<>();
        int[] row = new int[n];   // 第i行的皇后放在了第几列
        boolean[] col = new boolean[n];  // 第i列有无皇后
        dfs(n, 0, row, col, res, one);
        return res;
    }
    // 当前放置第now行，当前一种结果为one
    public void dfs(int n, int now, int[] row, boolean[] col, List<List<String>> res, List<String> one) {
        if (now == n) {
            List<String> t = new ArrayList<>(one);
            res.add(t);
        }
        // 在0~(n-1)列尝试放置
        for (int i = 0; i < n; ++i) {
            StringBuilder thisRow = new StringBuilder();   //这一行的内容
            if (col[i] == true) {   // 这一列已经有了
                continue;
            }
            int j = 0;
            // 判断对角线，行的差 == 列的差，说明在同一对角线
            for (j = 0; j < now; ++j) {
                if (Math.abs(row[j] - i) == Math.abs(j - now)) {
                    break;
                }
            }
            if (j < now) {
                continue;
            }
            // 放置
            row[now] = i;
            // 计算这一行的字符串，i前面是'.'，第i位是'Q'，后面(i+1)~(n-1)是'.'
            for (j =0; j < i; ++j) {
                thisRow.append(".");
            }
            thisRow.append("Q");
            for (j = i+1; j < n; ++j) {
                thisRow.append(".");
            }
            one.add(thisRow.toString());
            col[i] = true;  //记录这一列已经有了
            dfs(n, now+1, row, col, res, one);   //递归
            col[i] = false;   //回溯，要变化列，要让这一列没有
            one.remove(one.size() - 1);  // 把刚刚得到的这一行的答案删去，因为这一行要换一种答案了
        }
    }
}
