class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; ++i) {
            List<Integer> one = new ArrayList<Integer>();
            // 第一个1
            one.add(1);
            //添加中间部分，共i-2个
            for(int j = 0; j < i - 1; ++j) {
                one.add(res.get(i-1).get(j) + res.get(i-1).get(j+1));
            }
            // 添加右边的1，第1行不用
            if (i != 0) {
                one.add(1);
            }
            res.add(one);
        }
        return res;
    }
}
