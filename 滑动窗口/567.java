// 问题等价于s2中是否存在长度 == s1.length()的字串覆盖s1
// 相比于字串覆盖问题，限制了滑动窗口的大小 == s1.length()
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] mapS1 = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            mapS1[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, match = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            ++right;
            window[c - 'a']++;
            if (window[c - 'a'] == mapS1[c - 'a']) {
                match += window[c - 'a'];
            }
            // 找到了直接返回
            if (match == s1.length()) {
                return true;
            }
            // 限制窗口大小
            while (right - left >= s1.length()) {
                c = s2.charAt(left);
                ++left;
                if (window[c - 'a'] == mapS1[c - 'a']) {
                    match -= window[c - 'a'];
                }
                window[c - 'a']--;
            }
        }
        return false;
    }
}
