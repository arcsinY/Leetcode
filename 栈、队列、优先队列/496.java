// 使用map记录nums2中每个元素后面的第一个比这个大的元素
// 使用单调栈计算“下一个更大元素”
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        // 倒序遍历nums2，栈中记录的是nums2[i]之后的元素。
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            // <=nums2[i]的元素弹出，剩下的就是在nums2[i]之后，大于nums2[i]的元素
            while (stack.isEmpty() == false && num >= stack.getLast()) {
                stack.removeLast();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.getLast());
            stack.addLast(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
