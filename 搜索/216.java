class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        dfs(res, one, k, n, 0, 1);
        return res;
    }
    // 从start开始组合，用sum维护当前和
    public void dfs(List<List<Integer>> res, List<Integer> one, int k, int n, int sum, int start) {
        if (one.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(one));
            }
            return;
        }
        for (int i = start; i <= 9; ++i) {
            if (sum + i > n) {
                break;
            }
            one.add(i);
            dfs(res, one, k, n, sum + i, i + 1);
            one.remove(one.size() - 1);
        }
    }
}
