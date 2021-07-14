// 观察1：结果中只可能出现建筑的左右边缘位置，因此只需考虑每个建筑的左右边缘。因此需要遍历左右建筑的左右边缘
// 观察2：对于一个结果中的横坐标x，右边缘 <= x的建筑不会影响到x对应的纵坐标。
// 因此遍历到一个位置x时，为了确定x对应的纵坐标，需要遍历 (左边缘 <= x < 右边缘) 的建筑，选择这些建筑中最高的。复杂度为O(n^2)
// 为了降低复杂度，使用优先队列来寻找符合条件的最高建筑。由于输入数组的左边缘有序，右边缘无序，因此左边缘不符合要求的直接跳过，之后也不用再考虑。
// 左边缘符合要求的都先加入队列，之后再判断右边缘是否符合要求
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> twoBound = new ArrayList<>();
        // 左右边缘排序遍历
        for (int[] i : buildings) {
            twoBound.add(i[0]);
            twoBound.add(i[1]);
        }
        Collections.sort(twoBound);
        int index = 0;
        for (int i : twoBound) {
            // 符合左边缘要求的建筑入队
            while (index < buildings.length && buildings[index][0] <= i) {
                pq.add(new int[]{buildings[index][1], buildings[index][2]});
                ++index;
            }
            // 不符合右边缘要求的出队
            while (pq.isEmpty() == false && pq.peek()[0] <= i) {
                pq.poll();
            }
            int high = 0;
            // 没有符合要求的建筑
            if (pq.isEmpty()) {
                high = 0;
            } else {
                // 符合要求的建筑中最高的
                high = pq.peek()[1];
            }
            if (ans.size() == 0 || high != ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(i, high));
            }
        }
        return ans;
    }
}
