import java.util.*;

public class Solution {
        //给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
        //
        //返回 s 所有可能的分割方案。
        List <List<String>> res = new ArrayList<>();
        public List<List<String>> partition(String s) {
            dfs(s,0,new ArrayList<String>());
            return res;
        }
        public void dfs(String s,int start,ArrayList<String> temp){
            if(start == s.length()){
                res.add(new ArrayList<>(temp));
                return;
            }
            for(int i = start; i < s.length();i++){
                String s1 = s.substring(start,i + 1);
                if(!check(s1)){
                    continue;
                }
                temp.add(s1);
                dfs(s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
        public boolean check(String s){
            if(s.length() <= 1){
                return true;
            }
            int i = 0,j = s.length()-1;
            while(i < j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
}

