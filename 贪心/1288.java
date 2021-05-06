class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 起点相同时,按终点降序排序.保证只能是前一个区间覆盖后一个
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int res = intervals.length;
        // 当前的左右端点
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            // 覆盖
            if (left <= intervals[i][0] && right >= intervals[i][1]) {
                --res;
            }
            // 没有覆盖,更新左右端点
            if (right < intervals[i][1]) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return res;
    }
}
