// nums2从大到小访问（但不能排序，因为res的顺序取决于nums2的顺序），每次找nums1中最大的点去比，能比过就用，比不过就派最小的去比
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < nums2.length; ++i) {
            q.add(new int[]{i, nums2[i]});
        }
        int left = 0, right = nums1.length - 1;
        int[] res = new int[nums1.length];
        while (q.isEmpty() == false) {
            int[] t = q.poll();
            int idx = t[0];   // nums2中最大元素的下标
            int val = t[1];   // nums2中最大元素的值
            if (nums1[right] > val) {   // 能比过
                res[idx] = nums1[right];
                --right;
            } else {   // 比不过
                res[idx] = nums1[left];
                ++left;
            }
        }
        return res;
    }
}
