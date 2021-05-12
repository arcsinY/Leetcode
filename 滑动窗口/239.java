// 双端队列：1. 队头是队列中最大元素
//          2. 队列中元素从大到小有序
//          3. 队列中元素都在窗口范围内（实际上队列中存的是下表）
// 性质1保证了每次取出最大元素，性质2保证了性质1，性质3是题目要求
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int left = 0, right = k - 1;
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            // 队列维护：队尾元素 < 当前元素的都出队
            while (q.isEmpty() == false && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        res.add(nums[q.getFirst()]);
        ++right;
        ++left;
        while (right < nums.length) {
            // 只需判断队头是否在窗口内，因为指针每次移动1位，队列前两个元素不可能都在窗口外
            if (q.isEmpty() == false && q.getFirst() < left) {
                q.removeFirst();
            }
            while (q.isEmpty() == false && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            q.addLast(right);
            res.add(nums[q.getFirst()]);
            ++left;
            ++right;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
