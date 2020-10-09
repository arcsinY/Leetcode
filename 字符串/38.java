class Solution {
    public String countAndSay(int n) {
        StringBuffer res = new StringBuffer("1");
        for(int i=1;i<n;++i)
        {
            StringBuffer t = new StringBuffer();
            for(int j=0;j<res.length();)
            {
                int count=0;
                int k;
                for(k=j;k<res.length();)
                {
                    if(res.charAt(k) == res.charAt(j))
                    {
                        ++count;
                        ++k;
                    }
                    else
                        break;
                }
                t.append(String.valueOf(count)+res.charAt(j));
                j=k;
            }
            res=t;
        }
        return res.toString();
    }
}