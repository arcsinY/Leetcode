import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        dfs(nums,0,one,res);
        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> one, List<List<Integer>> res)
    {
        if(start == nums.length)
        {
            List<Integer> t = new ArrayList<>(one);
            res.add(t);
            return;
        }
        one.add(nums[start]);
        dfs(nums, start+1, one, res);
        one.remove(one.size()-1);
        dfs(nums, start+1, one, res);
    }
}