// 用一个整数的二进制代表集合中现有的字符
class Solution {
    int res = 0;
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        // 所有的字符串转化为二进制
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                // 如果这个字符串中有重复字符，直接删掉
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            if (mask != 0) {
                masks.add(mask);
            }
        }
        dfs(masks, 0, 0);
        return res;
    }
    // 从index位置开始搜索，当前字符集合为mask
    public void dfs(List<Integer> masks, int index, int mask) {
        if (index == masks.size()) {
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }
        if ((masks.get(index) & mask) == 0) {
            dfs(masks, index + 1, mask | masks.get(index));
        }
        dfs(masks, index + 1, mask);
    }
}
