class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        StringBuilder sb = trim(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    // 删去前缀、后缀、中间多余的空格
    public StringBuilder trim(String s) {
        StringBuilder res = new StringBuilder(s.length());
        int p1 = 0;   // 第一个不是空格的位置
        int p2 = s.length() - 1;    //会后一个不是空格的位置
        while (p1 < s.length() && s.charAt(p1) == ' ') {
            ++p1;
        }
        while (p2 >= 0 && s.charAt(p2) == ' ') {
            --p2;
        }
        for (int i = p1; i <= p2; ++i) {
            if (s.charAt(i) == ' ') {
                res.append(s.charAt(i));
                while (s.charAt(i) == ' ') {
                    ++i;
                }
                --i;
                continue;
            }
            res.append(s.charAt(i));
        }
        return res;
    }

    // 反转整个字符串
    // 第一个与最后一个交换，第二个与倒数第二个交换，……
    public void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char t = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, t);
            --end;
            ++start;
        }
    }

    // 每个单词反转
    public void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;
        for (int i = 0; i < sb.length(); ++i) {
            // 找到空格，反转start与空格之间的部分
            if (sb.charAt(i) == ' ') {
                reverse(sb, start, end - 1);
                start = i + 1;
                end = i + 1;
                continue;
            }
            ++end;
        }
        // 反转最后一个单词
        reverse(sb, start, end - 1);
    }
}
