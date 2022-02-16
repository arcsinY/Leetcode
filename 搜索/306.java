// 从第三个划分的数字开始，要找的数字就是固定的了。若能向后找到这个数字，则计算前一个数字与这个数字的和，作为下一个要找的数字
class Solution {
    public boolean isAdditiveNumber(String num) {
        return backtrace(num, 0, 0, 0, 0);
    }
    // sum：要找的数字，pre：前一个数字，count：已找到的数字个数
    public boolean backtrace(String num, int index, long sum, long pre, long count) {
        // 数字划分递归结束
        if (num.length() == index) {
            if (count >= 3) {
                return true;
            }
            return false;
        }
        long val = 0;
        // 向后找一个数字
        for (int i = index; i < num.length(); ++i) {
            // 数字不是0，且有前导0
            if (i > index && num.charAt(index) == '0') {
                return false;
            }
            val = val * 10 + num.charAt(i) - '0';
            if (count >= 2) {
                // 这个数字已经超过了要找的数字，继续添加数字只能更大，因此不用再找了
                if (sum < val) {
                    return false;
                } else if (sum > val) {
                    continue;
                }
            }
            if (backtrace(num, i + 1, pre + val, val, count + 1)) {
                return true;
            }
        }
        return false;
    }
}
