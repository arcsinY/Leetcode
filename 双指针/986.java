// 判断什么情况下两个区间有交集
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0;  // 两个区间数组的指针
        while (p1 < firstList.length && p2 < secondList.length) {
            int a1 = firstList[p1][0];
            int b1 = firstList[p1][1];
            int a2 = secondList[p2][0];
            int b2 = secondList[p2][1];
            // 有交集的情况
            if (b1 >= a2 && b2 >= a1) {
                int t1 = Math.max(a1, a2);
                int t2 = Math.min(b1, b2);
                res.add(new int[] {t1, t2});
            }
            if (b2 < b1) {
                ++p2;
            } else {
                ++p1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
