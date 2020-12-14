class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null)
            return null;
        if(a.length() == 0 || a.equals("0"))
            return b;
        if(b.length() == 0 || b.equals("0"))
            return a;
        int len = Math.max(a.length(), b.length());
        StringBuffer res = new StringBuffer(len);
        int carry=0;
        for(int i=0;i<len;++i)
        {
            if(i<a.length() && i<b.length())
            {
                int t = a.charAt(a.length()-1-i)-'0'+b.charAt(b.length()-1-i)-'0'+carry;
                if(t>=2)
                {
                    t %=2;
                    carry = 1;
                }
                else
                    carry=0;
                res.append((char)(t+'0'));
                continue;
            }
            if(i>=a.length())
            {
                int t = b.charAt(b.length()-1-i)-'0'+carry;
                if(t>=2)
                {
                    t %=2;
                    carry = 1;
                }
                else
                    carry=0;
                res.append((char)(t+'0'));
                continue;
            }
            if(i>=b.length())
            {
                int t = a.charAt(a.length()-1-i)-'0'+carry;
                if(t>=2)
                {
                    t %=2;
                    carry = 1;
                }
                else
                    carry=0;
                res.append((char)(t+'0'));
                continue;
            }
        }
        if(carry != 0)
            res.append((char)(1+'0'));
        res.reverse();
        return res.toString();
    }
}