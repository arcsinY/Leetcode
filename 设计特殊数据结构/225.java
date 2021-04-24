// 思想：数据入队后，将新入队的数据前面的所有数据出队再入队
// q1存储数据，q2辅助，每次新数据进入q2，q1全部元素出队加入q2，交换q1,q2保证只用q1存储全部数据
// 也可以只用一个队列，记录当前数据个数位n，每次新数据进入后，将前n个元素出队再入队
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (q1.isEmpty() == false) {
            int t = q1.poll();
            q2.add(t);
        }
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.element();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
