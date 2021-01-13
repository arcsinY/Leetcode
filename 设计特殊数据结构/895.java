import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    Map<Integer, Integer> val2Feq;    // 记录 一个数--频率
    Map<Integer, Stack<Integer>> feq2Val;  // 记录 频率--多个数。一个栈中的元素一定互不相同。比如push(x)3次，x会出现在1,2,3对应的栈中各一次
    int maxFeq;  // 当前最大频率
    public FreqStack() {
        val2Feq = new HashMap<Integer, Integer>();
        feq2Val = new HashMap<>();
        maxFeq = -1;
    }

    public void push(int x) {
        int feq = 0;
        // 取出x对应的feq
        // 先判断有没有x，没有放入，feq为1
        if (val2Feq.containsKey(x) == false) {
            val2Feq.put(x, 1);
        } else {  // 有，直接取出
            feq = val2Feq.get(x);
        }
        feq += 1;
        val2Feq.put(x, feq);   // 放回
        if (feq > maxFeq) {   // 更新maxFeq
            maxFeq = feq;
        }
        // 在对应feq的栈里加上x，先判断有没有feq对应的栈
        if (feq2Val.containsKey(feq) == false) {
            Stack<Integer> t = new Stack<>();
            t.push(x);
            feq2Val.put(feq, t);
        } else {
            feq2Val.get(feq).push(x);
        }
    }

    public int pop() {
        // 最大频率对应的栈弹出一个
        Stack<Integer> s = feq2Val.get(maxFeq);
        int x = s.pop();
        int feq = val2Feq.get(x);
        feq -= 1;
        // 修改这个数的频率
        val2Feq.put(x, feq);
        // 最大频率的数都弹出了，最大频率-1
        if (s.isEmpty()) {
            maxFeq--;
        }
        return x;
    }
}
