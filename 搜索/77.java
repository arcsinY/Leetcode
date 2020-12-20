import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<>();
        dfs(1,n,k,one, res);
        return res;
    }

    public void dfs(int start, int n, int k, List<Integer> one, List<List<Integer>> res)
    {
        if(one.size()+(n-start+1)<k)  //所有剩下得元素都加上也不可能得到k个
            return;
        if(one.size() == k)
        {
            List<Integer> t = new ArrayList<>(one);
            res.add(t);
            return;
        }
        one.add(start);   //将start加到结果中
        dfs(start+1, n,k,one,res);
        one.remove(one.size()-1);  //不要start
        dfs(start+1, n,k,one,res);
    }
}