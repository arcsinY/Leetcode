// 一个大根堆存储有序数组的前半部分
// 一个小根堆存储有序数组的后半部分
// 数据奇数个时，大根堆存储的数量 = 小根堆数量 + 1
// 新加入的数字不能确定存在大根堆中还是小根堆中，因此直接加入大根堆，之后让大根堆给小根堆一个数字，保证存储的顺序正确
// 如果加入新数字后有奇数个数字，说明之前有偶数个数字，目前小根堆数量 = 大根堆数量 + 1，因此让小根堆给大根堆一个数字，保证两个堆的大小正确
class MedianFinder {
    PriorityQueue<Integer> low;   // 大根堆
    PriorityQueue<Integer> high;  // 小根堆
    int cnt;
    /** initialize your data structure here. */
    public MedianFinder() {
        cnt = 0;
        low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        ++cnt;
        low.add(num);
        high.add(low.poll());
        if (cnt % 2 != 0) {
            low.add(high.poll());
        }
    }

    public double findMedian() {
        if (cnt % 2 == 0) {
            return (double)(low.peek() + high.peek()) / 2;
        } else {
            return low.peek();
        }
    }
}
