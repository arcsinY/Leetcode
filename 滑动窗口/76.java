// 滑动窗口的范围是[left, right)
class Solution {
    public String minWindow(String s, String t) {
        int[] window = new int[60];
        int[] mapT = new int[60];
        for (int i = 0; i < t.length(); ++i) {
            mapT[t.charAt(i) - 'A']++;
        }
        int left = 0, right = 0;
        int match = 0;   // 已经匹配的字符数，==t.length()时说明能够覆盖
        int resStart = -1, resLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 更新窗口内容
            window[c - 'A']++;
            if (window[c - 'A'] == mapT[c - 'A']) {
                match += mapT[c - 'A'];
            }
            // 缩小窗口
            while (match == t.length()) {
                if (right - left < resLen) {
                    resStart = left;
                    resLen = right - left;
                }
                c = s.charAt(left);
                ++left;
                // 更新窗口内容
                if (window[c - 'A'] == mapT[c - 'A']) {
                    match -= mapT[c - 'A'];
                }
                window[c - 'A']--;
            }
        }
        if (resStart != -1) {
            return s.substring(resStart, resStart + resLen);
        }
        return "";
    }
}
