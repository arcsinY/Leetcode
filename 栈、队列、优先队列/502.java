// 贪心法：每次选择符合当前本金限制的利润最大的项目投资
// 怎么判断项目利润最大：优先队列（大根堆）
// 怎么更新符合本金限制的项目：按本金排序，顺序向后遍历
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int idx = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        // 项目按照所需资金排序，之后每次只需顺序向后选取项目加入优先队列
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        // 选 k 个项目
        for (int i = 0; i < k; ++i) {
            // 符合当前资金限制的加入优先队列，每次选出利润最大的项目投资
            while (idx < n && arr[idx][0] <= w) {
                pq.add(arr[idx][1]);
                ++idx;
            }
            // 随时更新手里有的钱，可以作为结果
            if (pq.isEmpty() == false) {
                w += pq.poll();
            } else {
                break;
            }
        }
        return w;
    }
}
