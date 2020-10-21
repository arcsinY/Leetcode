import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> now= new ArrayList<>();
        ArrayList<Boolean> used = new ArrayList<>();
        for(int i=0;i<nums.length;++i)
        {
            used.add(Boolean.FALSE);
        }
        dfs(nums,res, now,used);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> now, ArrayList<Boolean> used)
    {
        if(now.size() == nums.length)
        {
            ArrayList<Integer> t = new ArrayList<>(now);
            res.add(t);
            return;
        }
        for(int i=0;i<nums.length;++i)
        {
            if(used.get(i) == true)
                continue;
            now.add(Integer.valueOf(nums[i]));
            used.set(i,Boolean.TRUE);
            dfs(nums, res, now, used);
            used.set(i,Boolean.FALSE);
            now.remove(now.size()-1);
        }
    }
}