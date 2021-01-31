class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            cur.add(1);
            for (int j = 1; j < i; ++j) {
                cur.add(pre.get(j-1) + pre.get(j));
            }
            cur.add(1);
            pre = new ArrayList<Integer>(cur);
            cur.clear();
        }
        return pre;
    }
}
