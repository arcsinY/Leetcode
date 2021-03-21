import java.util.Deque;
import java.util.LinkedList;
// 一个数据栈，一个最小元素栈，栈顶保存当前数据栈中的最小元素
// 当插入数据<=最小元素时，更新最小元素栈
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.addFirst(x);
        if (minStack.isEmpty() == true) {
            minStack.addFirst(x);
        } else {
            if (x <= minStack.getFirst()) {
                minStack.addFirst(x);
            }
        }
    }

    public void pop() {
        int a = stack.getFirst();
        stack.removeFirst();
        if (a <= minStack.getFirst()) {
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }
}
