// 选择列表：从index开始所有能组成的数字，在这个数字前面添加三种运算符
// 由于乘法运算的优先级高，因此选择乘法运算时，要取回上一个操作数，先将上一个操作数与这个数做乘法，再加到当前结果上
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder one = new StringBuilder();
        dfs(num, target, 0, 0, res, one, 0);
        return res;
    }
    // last是上一个操作数
    public void dfs(String num, int target, int index, long curValue, List<String> res, StringBuilder one, long last) {
        if (index == num.length()) {
            if (target == curValue) {
                res.add(new String(one));
                return;
            }
        }
        // 保存选择之前的状态，用于选择完成后撤销选择
        StringBuilder bakcup = new StringBuilder(one);
        // 数字的选择
        for (int i = index; i < num.length(); ++i) {
            String t = num.substring(index, i + 1);
            long t2 = Long.parseLong(t);
            // 第一个操作数，前面不需要运算符
            if (index == 0) {
                one.append(t);
                dfs(num, target, i + 1, t2, res, one, t2);
                one = new StringBuilder(bakcup);
            } else {
                // 运算符的选择
                one.append("+" + t);
                dfs(num, target, i + 1, curValue + t2, res, one , t2);
                one = new StringBuilder(bakcup);
                one.append("-" + t);
                dfs(num, target, i + 1, curValue - t2, res, one, -t2);
                one = new StringBuilder(bakcup);
                one.append("*" + t);
                dfs(num, target, i + 1, curValue - last + last * t2, res, one, last * t2);
                one = new StringBuilder(bakcup);
            }
            // 运算序列中每个操作数不能出现前导0
            if (t2 == 0) {
                return;
            }
        }
    }
}
