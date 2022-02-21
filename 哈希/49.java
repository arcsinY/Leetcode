class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] alphabet = new int[26];  //每个单词的字母表
        Map<int[], Integer> alp_int = new HashMap<>();  //记录字母表和这种组合在 res 中的 index
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        for(int i=0;i<strs.length;++i)
        {
            Arrays.fill(alphabet, 0);
            //计算单词i的字母表
            for(int j=0;j<strs[i].length();++j)
            {
                char t = strs[i].charAt(j);
                alphabet[t-'a']++;
            }
            //int j;
            boolean have=false;
            for(int[] j:alp_int.keySet())
            {
                if(Arrays.equals(j,alphabet))   //这个字母排列出现过
                {
                    int t = alp_int.get(j);
                    res.get(t).add(strs[i]);
                    have=true;
                    break;
                }

            }
            if(have == false)  //这个字母排列没出现过
            {
                int[] alphabet2 = new int[26];
                alphabet2 =  Arrays.copyOf(alphabet, 26);
                // 加入一种新的组合方式
                alp_int.put(alphabet2, alp_int.size());
                ArrayList<String> tt = new ArrayList<>();
                tt.add(strs[i]);
                res.add(tt);
            }
        }
        return res;
    }
}
