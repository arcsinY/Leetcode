// 判断[left, right)的字串是否有重复字符
public class Solution {
    public int lengthOfLongestSubstring (String s) {
        int ans = 0;
        int left = 0, right = 0;
        // 记录出现过的字符
        Set<Character> set = new HashSet<>();
        // 由于right是开区间，因此最大可以另right == s.length()
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 不允许之前出现过字符c
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
