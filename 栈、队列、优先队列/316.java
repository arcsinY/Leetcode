// 单调栈：从栈底到栈顶的元素有序。每次一个元素想要插入栈中时，先与栈顶元素进行对比，将不符合顺序的栈顶元素弹出
// 这道题弹出栈顶元素时要考虑后面还有没有这个字母，保证字母不丢失
class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        int[] cnt = new int[26];
        boolean[] vis = new boolean[26];   // 一个字母是否在栈中，已经在栈中不需要再次push，实现去重
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        for (char c : s.toCharArray()) {
            if (vis[c - 'a']) {
                --cnt[c - 'a'];
                continue;
            }
            while (stack.isEmpty() == false && stack.getLast() > c) {
                if (cnt[stack.getLast() - 'a'] == 1) {
                    break;
                }
                char t = stack.removeLast();
                vis[t - 'a'] = false;
                --cnt[t - 'a'];
            }
            stack.addLast(c);
            vis[c - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (stack.isEmpty() == false) {
            ans.append(stack.removeLast());
        }
        return ans.reverse().toString();
    }
}
