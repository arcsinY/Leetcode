// 要求映射为单射，因此不能只记录s->t的映射，还需记录t->s的映射
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();    // s->t的映射
        Set<Character> set = new HashSet<>();    // 记录t中的一个字符是否已经被映射过
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                char c = map.get(s.charAt(i));
                if (c != t.charAt(i)) {
                    return false;
                }
            } else {
                // t中这个字符已经被s中别的字符映射过，不能再被映射
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}
