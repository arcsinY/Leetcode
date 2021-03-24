// 将1-26映射到0-25，因此每次将数字-1
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            res.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
