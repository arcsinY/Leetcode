import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //去重的排列组合问题需要先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, one, 0, used);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> one, int start, boolean[] used){
        //当前结果加入最终结果
        ArrayList<Integer> t = new ArrayList<>(one);
        res.add(t);
        //从开始位置向后遍历，每个元素分为加入集合和不加入集合两种情况
        for(int i=start;i<nums.length;++i){
            //used[i-1]==true说明同一树枝使用过，可以继续使用，因为一个子集中可以有重复元素
            //used[i-1] == false说明同一树层使用过，不能继续使用，因为不能用相同子集
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            //当前元素加入当前结果
            used[i] = true;
            one.add(nums[i]);
            dfs(nums, res, one, i+1, used);
            //当前元素不加入当前结果
            used[i] = false;
            one.remove(one.size()-1);
        }
    }
}
