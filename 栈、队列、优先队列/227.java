// 遇到*和/就直接运算，遇到'+'则将后面的数字放入栈中，遇到'-'将后面的数字取相反数放入栈中。最终对栈中数字求和
// 用sign记录当前数字前面的符号
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        int res = 0;
        int t = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); ++i) {
            // num记录当前一个数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 得到了一个数字，看它前面的符号是什么
            if (Character.isDigit(s.charAt(i)) == false && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.addLast(num);
                        break;
                    case '-':
                        stack.addLast(-num);
                        break;
                    case '*':
                        t = stack.getLast();
                        stack.removeLast();
                        stack.addLast(num * t);
                        break;
                    case '/':
                        t = stack.getLast();
                        stack.removeLast();
                        stack.addLast(t / num);
                        break;
                    default:
                        break;
                }
                // 当前位置上是符号，记下来
                sign = s.charAt(i);
                num = 0;
            }
        }
        while (stack.isEmpty() == false) {
            res += stack.getLast();
            stack.removeLast();
        }
        return res;
    }
}
