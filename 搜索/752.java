class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String i: deadends) {
            dead.add(i);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        Set<String> visit = new LinkedHashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visit.add("0000");
        int res = 0;
        while (q.isEmpty() == false) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String t = q.poll();
                if (t.equals(target)) {
                    return res;
                }
                // 拓展状态
                for (int j = 0; j < 4; ++j) {
                    String t2 = up(t, j);
                    if (dead.contains(t2) == false && visit.contains(t2) == false) {
                        q.add(t2);
                        visit.add(t2);
                    }
                    t2 = down(t, j);
                    if (dead.contains(t2) == false && visit.contains(t2) == false) {
                        q.add(t2);
                        visit.add(t2);
                    }
                }
            }
            ++res;
        }
        return -1;
    }
    // 第i位向上一位
    public String up(String s, int i) {
        char[] arr = s.toCharArray();
        if (arr[i] == '9'){
            arr[i] = '0';
        } else {
            arr[i]++;
        }
        return new String(arr);
    }
    public String down(String s, int i) {
        char[] arr = s.toCharArray();
        if (arr[i] == '0'){
            arr[i] = '9';
        } else {
            arr[i]--;
        }
        return new String(arr);
    }
}
