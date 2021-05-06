// 贪心策略：每次选择结尾位置最大的区间
class Solution {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) {
            return 0;
        }
        // 区间起点升序排序，因为之后要找起点＜当前重点的区间
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        int curEnd = 0, nextEnd = 0, i = 0;
        // 要求起点 ＜　当前结尾位置
        while (i < clips.length && clips[i][0] <= curEnd) {
            while (i < clips.length && clips[i][0] <= curEnd) {
                if (clips[i][1] > nextEnd) {
                    nextEnd = clips[i][1];
                }
                ++i;
            }
            ++res;
            if (nextEnd >= T) {
                return res;
            }
            curEnd = nextEnd;
        }
        return -1;
    }
}
