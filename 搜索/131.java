import java.util.ArrayList;
import java.util.List;
// 回溯法三步骤：
// 1. 选择当前一种结果
// 2. 递归
// 3. 删除当前选择（回溯）
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> one = new ArrayList<>();
        dfs(s, 0, res, one);
        return res;
    }
    void dfs(String s, int start, List<List<String>> res, List<String> one) {
        // 递归结束条件，字符串遍历完成
        if (start >= s.length()) {
            List<String> t = new ArrayList<>(one);
            res.add(t);
            return;
        }
        // 当前拆分出的字符串的结束位置
        for (int i = start; i < s.length(); ++i) {
            String a = s.substring(start, i + 1);
            if (isPalindrome(a)) {
                one.add(a);   // 放置
                dfs(s, i + 1, res, one);   // 递归
                one.remove(one.size() - 1);    // 删除当前的选择（回溯）
            }   
        }
    }
    // 判断是否为回文串，也可以用动态规划，空间换时间 
    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
