class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();     // 窗口内各个字母的个数，保证窗口内所有字母都只出现一次
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 原窗口中所有字母都是只出现一次，因此如果窗口内出现了重复字母，一定是新加入的重复了
            while (window.get(c) > 1) {
                char t = s.charAt(left);
                window.put(t, window.get(t) - 1);
                ++left;
            }
            if (right - left > res) {
                res = right - left;
            }
        }
        return res;
    }
}
