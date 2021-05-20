class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 引用次数 >= citations[mid]的文章 == citations[mid]篇，得到结果
            if (citations[mid] == citations.length - mid) {
                return citations.length - mid;
            // 引用次数 >= h的文章 < h篇，说明h太大了
            } else if (citations[mid] > citations.length - mid) {
                high = mid - 1;
            // 引用次数 >= h的文章 > h篇，说明h太小了
            } else if (citations[mid] < citations.length - mid) {
                low = mid - 1;
            }
        }
        return citations.length - low;
    }
}
