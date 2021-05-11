// 遇到一个运算符，递归计算两边的表达式可能存在的值，之后按照这个运算符组合两边所有的值，得到结果
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();   // 备忘录
    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        // 递归出口，basecase
        if (expression.length() == 1) {
            res.add(expression.charAt(0) - '0');
        }
        // 遍历所有的运算符
        for (int i = 0; i < expression.length(); ++i) {
            char t = expression.charAt(i);
            if (t == '+' || t == '-' || t == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                // 左右结果组合
                for (int j : left) {
                    for (int k : right) {
                        switch (t) {
                            case '+':
                                res.add(j + k);
                                break;
                            case '-':
                                res.add(j - k);
                                break;
                            case '*':
                                res.add(j * k);
                                break;
                        }
                    }
                }
            }
        }
        // 表达式没有运算符的情况
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        map.put(expression, res);
        return res;
    }
}
