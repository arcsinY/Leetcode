import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> once = new ArrayList<Integer>();
        ArrayList<Boolean> used = new ArrayList<>(candidates.length);
        for(int i=0;i<candidates.length;++i)
        {
            used.add(Boolean.FALSE);
        }
        Arrays.sort(candidates);
        dfs(res, once, candidates, target, 0, used);
        return res;
    }
    //从index位置开始，选出和为target的组合
    public  void dfs(ArrayList<List<Integer>> res, List<Integer> once, int[] candidate, int target, int index, ArrayList<Boolean> used)
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
            if(i>0 && candidate[i] == candidate[i-1] && used.get(i - 1) == Boolean.FALSE)
                continue;
            once.add(Integer.valueOf(candidate[i]));
            //used[i]==true，说明在这一搜索分支用过candidate[i]。used[i]==false，说明在同一层不同分支用过candidate[i]
            used.set(i, Boolean.TRUE);
            dfs(res, once, candidate, target-candidate[i], i+1, used);  //一个元素不允许使用两次了
            once.remove(once.size()-1);  //这次不选这个元素了，选下一个元素
            used.set(i,Boolean.FALSE);
        }
    }
}