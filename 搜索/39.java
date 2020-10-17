import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> once = new ArrayList<Integer>();
        dfs(res, once, candidates, target, 0);
        return res;
    }
    //从index位置开始，选出和为target的组合
    public  void dfs(ArrayList<List<Integer>> res, List<Integer> once, int[] candidate, int target, int index)
    {
        if(target<0)
            return;
        if(target == 0)
        {
            ArrayList<Integer> t = new ArrayList<>(once);
            res.add(t);
            return;
        }
        //如果是排列问题，i从0开始
        for(int i=index;i<candidate.length;++i)
        {
            once.add(Integer.valueOf(candidate[i]));
            dfs(res, once, candidate, target-candidate[i], i);  //由于同一元素还可以继续用，所以index还是i
            once.remove(once.size()-1);  //这次不选这个元素了，选下一个元素
        }
    }
}