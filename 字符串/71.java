import java.util.ArrayList;
import java.util.List;

class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
            return path;
        List<String> resArr = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        res.append("/");
        StringBuffer one = new StringBuffer(0);
        for(int i=1;i<path.length();++i)
        {
            if(path.charAt(i) == '/')  //得到一段路径
            {
                if(one.length() == 0)
                {
                    one.setLength(0);
                    continue;
                }
                //StringBuffer不能直接与String判断equals，要先转为String
                if(one.toString().equals(".."))  //删除最后一段路径，代表返回上一级
                {
                    if(resArr.size() != 0)
                        resArr.remove(resArr.size()-1);
                    one.setLength(0);
                    continue;
                }
                if(one.toString().equals("."))  //不变
                {
                    one.setLength(0);
                    continue;
                }
                resArr.add(one.toString());  //这是一个真正的路径，加到总路径上
                one.setLength(0);
            }
            else
                one.append(path.charAt(i));
        }
        if(one.length() !=0)  //最后一段路径
        {

            if(one.toString().equals(".."))
            {
                if(resArr.size() != 0)
                    resArr.remove(resArr.size()-1);
                one.setLength(0);
            }
            if(one.toString().equals("."))
                one.setLength(0);
            if(one.length() != 0)
                resArr.add(one.toString());

        }
        for(int i=0;i<resArr.size();++i)  //合成结果，结尾多一个/
        {
            res.append(resArr.get(i).toString());
            res.append("/");
        }
        if(res.length() >= 2)
            res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}