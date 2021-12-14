// 贪心策略1：优先上lastDay在前面的课程
// 贪心策略2：优先上duration短的课程
class Solution {
    public int scheduleCourse(int[][] courses) {
        // 按照lastDay排序
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        // 已选择的课程中，记录duration最长的，之后可能要替换调这门课
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        // 当前花费的时间
        int timeSum = 0;
        for (int i = 0; i < courses.length; ++i) {
            int time = courses[i][0];
            int lastDay = courses[i][1];
            // 可以选下一门课，直接选上
            if (timeSum + time <= lastDay) {
                timeSum += time;
                pq.offer(courses[i]);
            } else {
                // 不能选下一门课，将前面的一门时间最长的替换调
                if (pq.isEmpty() == false && pq.peek()[0] > time) {
                    pq.add(courses[i]);
                    timeSum -= pq.poll()[0];
                    timeSum += time;
                }
            }
        }
        return pq.size();
    }
}
