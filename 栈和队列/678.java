// 在括号匹配的基础上加入了 '*'
// 单独一个栈存放遇到的 '*'，遇到 ')' 时，优先使用现有的左括号匹配，之后再使用星号匹配
// 最优用剩下的左括号和星号匹配
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> starStack = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                leftStack.addLast(i);
            } else if (s.charAt(i) == '*') {
                starStack.addLast(i);
            } else {
                // 优先使用左括号匹配
                if (leftStack.isEmpty() == false) {
                    leftStack.removeLast();
                } else if (starStack.isEmpty() == false) {
                    starStack.removeLast();
                } else {
                    return false;
                }
            }
        }
        while (leftStack.isEmpty() == false && starStack.isEmpty() == false) {
            int leftIndex = leftStack.removeLast();
            int starIndex = starStack.removeLast();
            // 先星号，再左括号 不合法
            if (leftIndex > starIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
