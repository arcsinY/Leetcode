// dfs遍历所有情况 + 剪枝
// 每个字符都有加入或不加入两种情况，时间复杂度2^n
// 剪枝策略：一个 '(' 计1分，一个 ')' 计-1分，字符串能出现的最大分数为min(左括号数量，右括号数量)，因为最大分数情况就是结果中左括号全在左边，之后右括号
// 最小分数为-1，因为如果当前字符串右括号数量 > 左括号数量，已经不可能匹配了
class Solution {
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                ++l;
            }
            if (i == ')') {
                ++r;
            }
        }
        int max = Math.min(l, r);
        String one = new String();
        backtrack(s, one, set, 0, 0, max);
        for (String i : set) {
            if (i.length() == len) {
                ans.add(i);
            }
        }
        return ans;
    }
    // 结果先存入set去重，最后再取最长的那部分
    public void backtrack(String s, String one, Set<String> set, int index, int curScore, int max) {
        // 结束条件，遍历完字符串了
        if (index == s.length()) {
            // 合法解
            if (curScore == 0 && one.length() >= len) {
                len = one.length();
                set.add(one);
            }
            return;
        }
        if (s.charAt(index) == '(') {
            if (curScore + 1 <= max) {
                backtrack(s, one + '(', set, index + 1, curScore + 1, max);
            }
            backtrack(s, one, set, index + 1, curScore, max);
        } else if (s.charAt(index) == ')') {
            if (curScore > 0) {
                backtrack(s, one + ')', set, index + 1, curScore - 1, max);
            }
            backtrack(s, one, set, index + 1, curScore, max);
        } else {
            backtrack(s, one + s.charAt(index), set, index + 1, curScore, max);
        }

    }
}
