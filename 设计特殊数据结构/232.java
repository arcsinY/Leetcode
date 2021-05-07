// 使用两个栈，一个用于入队列操作，将入队元素加到栈顶
// 另一个用于pop、peek操作，保证栈顶元素就是队头。当这个栈为空时，将另一个栈的元素弹出到这个栈中
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            while (inStack.isEmpty() == false) {
                int t = inStack.getLast();
                inStack.removeLast();
                outStack.addLast(t);
            }
        }
        int t = outStack.getLast();
        outStack.removeLast();
        return t;
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            while (inStack.isEmpty() == false) {
                int t = inStack.getLast();
                inStack.removeLast();
                outStack.addLast(t);
            }
        }
        return outStack.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
