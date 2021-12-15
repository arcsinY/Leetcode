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
    
    // 如果当前插入的数据不是最小元素，后续的min操作不可能返回这个元素
    // 因为在这个元素之前进栈的有比它更小的
    public void push(int x) {
        stack.addFirst(x);
        if (minStack.isEmpty() || x <= minStack.getFirst()) {
            minStack.addFirst(x);
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
