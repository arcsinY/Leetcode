import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//排列问题的去重，既可以在搜索分支上去重，也可以在同层中去重。同层去重更好
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> now= new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,res, now, used);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> now, boolean[] used)
    {
        if(now.size() == nums.length)
        {
            ArrayList<Integer> t = new ArrayList<>(now);
            res.add(t);
            return;
        }
        for(int i=0;i<nums.length;++i)
        {
            if(used[i] == true)
                continue;
            //used[i-1]==true，说明在同一分支上。used[i-1]==false，说明在同一层
            if(i>0 && nums[i] == nums[i-1] && used[i-1]==false)
                continue;
            now.add(Integer.valueOf(nums[i]));
            used[i]=true;
            dfs(nums, res, now, used);
            used[i]=false;
            now.remove(now.size()-1);
        }
    }
}