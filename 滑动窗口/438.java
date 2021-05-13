class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            need[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, match = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window[c - 'a']++;
            if (window[c - 'a'] == need[c - 'a']) {
                match += window[c - 'a'];
            }
            if (match == p.length()) {
                res.add(left);
            }
            while (right - left >= p.length()) {
                c = s.charAt(left);
                ++left;
                if (window[c - 'a'] == need[c - 'a']) {
                    --match;
                }
                window[c - 'a']--;
            }
        }
        return res;
    }
}
