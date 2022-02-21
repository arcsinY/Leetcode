// 既有下表的限制条件又有数大小的限制，因此利用滑动窗口，确保满足一个条件
// 要找间隔 <= t的数对，则每个桶存储的数据范围 = t+1
// 这个数对应的桶中已经有数了，说明两数间隔 <= t，返回true
// 还要判断相邻桶中的元素与当前元素的差，不相邻的桶与当前元素的差一定 > t
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> bin = new HashMap<>();   // 记录(桶id,数)
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long id = getId(nums[i], w);
            // 这个桶里已经有了
            if (bin.containsKey(id)) {
                return true;
            }
            // 相邻桶
            if (bin.containsKey(id - 1) && Math.abs(bin.get(id - 1) - i) <= t) {
                return true;
            }
            if (bin.containsKey(id + 1) && Math.abs(bin.get(id + 1) - i) <= t) {
                return true;
            }
            // 为这个数创建一个桶
            bin.put(id, (long)i);
            // 不在滑动窗口中的数据删掉
            if (i >= k) {
                bin.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }
    // 桶的数据范围 = w，计算数据a所在的桶id（可以为负）
    public long getId(long a, long w) {
        if (a < 0) {
            return (a + 1) / w - 1;
        }
        return a / w;
    }
}
