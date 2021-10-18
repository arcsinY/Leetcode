// 贪心：首先放一个出现次数最大的字符，之后放一个第二大的字符。放完后更新字符的出现次数
// 大根堆的使用：存26个字母，使用局部变量cnt作为排序依据。一个字母取出并更新出现频次后，再放入一次
class Solution {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
            max = Math.max(max, cnt[s.charAt(i) - 'a']);
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {return cnt[b - 'a'] - cnt[a - 'a'];});
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != 0) {
                pq.offer((char)('a' + i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() > 1) {
            char c1 = pq.poll();
            char c2 = pq.poll();
            ans.append(c1);
            ans.append(c2);
            cnt[c1 - 'a']--;
            cnt[c2 - 'a']--;
            if (cnt[c1 - 'a'] != 0) {
                pq.offer(c1);
            }
            if (cnt[c2 - 'a'] != 0) {
                pq.offer(c2);
            }
        }
        if (pq.isEmpty() == false) {
            ans.append(pq.poll());
        }
        return ans.toString();
    }
}
