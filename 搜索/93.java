class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int[] pos = new int[4];  // 记录加'.'的位置。s[0]~s[pos[0]]是第一段，s[pos[1]+1]~s[pos[2]]是第二段
        dfs(s, res, 0, 0, pos);
        return res;
    }
    // 从s[start]开始搜索，segNum记录当前搜索的是第几个ip段（0~3）
    public void dfs(String s, List<String> res, int start, int segNum, int[] pos) {
        if (segNum == 4) {  // 找到了4个段
            if (start == s.length()) {   // 同时s所有字符都已经用完了，说明这是一种答案
                StringBuffer oneAddress = new StringBuffer(s);
                for (int i = 0; i < 3; i++) {   // 只需加3个'.'，因此循环3次，pos[3]不用考虑
                    // pos[0]+1是第一个点的位置，是每加一个'.'后字符串长度会+1，因此要+i表示下一个点的位置
                    oneAddress.insert(pos[i] + i + 1, ".");
                }
                res.add(oneAddress.toString());
            }
            return;
        }
        // s字符用完了，但没找到4个ip段，不符合要求
        if (start == s.length()) {
            return;
        }
        // 这一位是0，由于不能有前导0，因此这一位只能单独一段
        if (s.charAt(start) == '0') {
            pos[segNum] = start;
            dfs(s, res, start + 1, segNum + 1, pos);
            return;
        }
        int t = 0;  // 当前搜索得到的ip段对应的整数
        for(int i = start; i < s.length(); ++i) {
            t = t * 10 + (s.charAt(i)-'0');   //计算新的t
            if (t <= 255 && t > 0) {   // t<=255是可以的，由于0单独考虑了，因此要求>0
                pos[segNum] = i;
                dfs(s, res, i + 1, segNum + 1, pos);
            } else {
                break;
            }
        }
    }
}
