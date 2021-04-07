class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); ++i) {
            if (map.containsKey(pattern.charAt(i))) {
                if (sArr[i].equals(map.get(pattern.charAt(i))) == false) {
                    return false;
                }
            } else {
                if (set.contains(sArr[i])) {
                    return false;
                }
                set.add(sArr[i]);
                map.put(pattern.charAt(i), sArr[i]);
            }
        }
        return true;
    }
}
