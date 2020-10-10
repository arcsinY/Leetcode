import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, res, combine, target, 0);
        return res;
    }
    public void dfs(int[] cand, List<List<Integer>>res, List<Integer> combine, int target, int index)
    {
        if(index == cand.length)
            return;
        if(target == 0)
        {
            res.add(new ArrayList<Integer>(combine));   //不能直接add(combine)。因为后面combine变了，res里的也会变
            return;
        }
        dfs(cand, res, combine, target, index+1);
        if(target>=cand[index])
        {
            combine.add(Integer.valueOf(cand[index]));
            dfs(cand, res, combine, target-cand[index], index);
            combine.remove(combine.size() - 1);   //删去刚刚加入的元素
        }
    }
}