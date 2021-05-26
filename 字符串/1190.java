// 一个StringBuilder记录一组括号之间的内容。遇到 ) 时，反转StringBuilder
// 遇到 ( 时，现有内容存在栈里
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                stack.addLast(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(i) == ')') {
                sb.reverse();
                sb.insert(0, stack.getLast());
                stack.removeLast();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
