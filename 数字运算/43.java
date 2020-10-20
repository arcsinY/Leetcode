class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0")
            return String.valueOf(0);
        String res=new String();
        int len = num1.length()>num2.length()?num1.length():num2.length();
        //令num1>num2
        if(num1.length()< num2.length())
        {
            String t = num1;
            num1=num2;
            num2=t;
        }
        if(num1.length() == num2.length() && num1.charAt(0)<num2.charAt(0))
        {
            String t = num1;
            num1=num2;
            num2=t;
        }
        for(int i=num2.length()-1;i>=0;--i)
        {
            String t = multi(num1, Integer.valueOf(num2.charAt(i)-'0'), num2.length()-1-i);
            res = sum(res,t);
        }
        return res;
    }
    public String multi(String num, int num2, int zero)
    {
        StringBuffer res = new StringBuffer();
        if(num2==0)
            return String.valueOf(0);
        int t=0,up=0,n=0;
        for(int i=num.length()-1;i>=0;--i)
        {
           // System.out.println(Integer.valueOf(num.charAt(i)));
            t = num2*Integer.valueOf(num.charAt(i)-'0')+up;
            up = t/10;
            n = t%10;
            res.append(String.valueOf(n));
        }
        if(up != 0)
            res.append(String.valueOf(up));
        res.reverse();
        for(int i=0;i<zero;++i)
        {
            res.append(String.valueOf(0));
        }
        return res.toString();
    }

    public String sum(String num1, String num2)
    {
        StringBuffer res = new StringBuffer();
        //令num1>num2
        if(num1.length()< num2.length())
        {
            String t = num1;
            num1=num2;
            num2=t;
        }
        if(num1.length() == num2.length() && num1.charAt(0)<num2.charAt(0))
        {
            String t = num1;
            num1=num2;
            num2=t;
        }
        int t=0,up=0,n=0;
        int i,j;
        for(i=num2.length()-1,j=num1.length()-1;i>=0 && j>=0;--i,--j)
        {
            t = Integer.valueOf(num2.charAt(i) - '0') + Integer.valueOf(num1.charAt(j) - '0') + up;
            up = t/10;
            n = t%10;
            res.append(String.valueOf(n));
        }
        while(j>=0)
        {
            t = Integer.valueOf(num1.charAt(j)-'0')+up;
            up = t/10;
            n = t%10;
            res.append(String.valueOf(n));
            --j;
        }
        if(up != 0)
            res.append(String.valueOf(up));
        res.reverse();
        return res.toString();
    }
}