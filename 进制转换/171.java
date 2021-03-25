class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int rad = 1;
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            res += rad * (columnTitle.charAt(i) - 'A' + 1);
            rad *= 26;
        }
        return res;
    }
}
