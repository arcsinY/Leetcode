import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        //int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; ++i) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.addFirst(Integer.parseInt(tokens[i]));
                continue;
            }
            int a = stack.getFirst();
            stack.removeFirst();
            int b = stack.getFirst();
            stack.removeFirst();
            switch (tokens[i].charAt(0)) {
                case '+':
                    stack.addFirst(a + b);
                    break;
                case '-':
                    stack.addFirst(b - a);
                    break;
                case '*':
                    stack.addFirst(a * b);
                    break;
                case '/':
                    stack.addFirst(b / a);
                    break;
            }
        }
        return stack.getFirst();
    }
}
