// 模拟除法。当余数重复出现时，说明开始循环
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            res.append("-");
        }
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        long remainder = 0;   // 余数
        // 计算整数部分
        res.append(String.valueOf(a / b));
        remainder = a % b;
        if (remainder == 0) {
            return res.toString();
        }
        res.append(".");
        int idx = res.length();
        // 存储余数和在结果中对应的位置
        Map<Long, Integer> map = new HashMap<>();
        // 开始计算小数部分
        while (remainder != 0) {
            // 是否出现了循环
            if (map.containsKey(remainder)) {
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            }
            map.put(remainder, idx++);
            remainder *= 10;
            long t = remainder / b;
            res.append(String.valueOf(t));
            remainder %= b;
        }
        return res.toString();
    }
}
