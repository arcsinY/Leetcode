// nums1中可以选出x个元素，nums2中可以选出y个元素，满足 x + y == k
// 一个数组中选出的元素一定是最大的子序列，之后两个子序列合并得到结果
// 利用单调栈得到数组中长度为 k 的最大子序列：开始按照单调栈将尽可能大的元素放入前面，当数组中剩下元素+栈中当前元素 <=k 时，不再执行单调栈的操作，后面的元素只能放入栈中
// 合并时如果两个数组当前位置的元素相同，则要选择后面的子数组更大的那个
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = null;
        // 从nums1中选i个元素
        for (int i = 0; i <= k; ++i) {
            int j = k - i;
            if (i > m || j < 0 || j > n) {
                continue;
            }
            int[] a = maxSubSequence(nums1, i);
            int[] b = maxSubSequence(nums2, j);
            int[] t = merge(a, b);
            if (ans == null) {
                ans = t;
            } else {
                if (compare(ans, 0, t, 0) == false) {
                    ans = t;
                }
            }
        }
        return ans;
    }
    public int[] maxSubSequence(int[] nums, int k) {
        List<Integer> ret = new LinkedList<>();
        // remainder：还需要的元素数量 - 数组中剩余元素数量
        int remain = nums.length - k;
        for (int i = 0; i < nums.length; ++i) {
            int t = nums[i];
            while (ret.size() != 0 && ret.get(ret.size() - 1) < t && remain > 0) {
                ret.remove(ret.size() - 1);
                --remain;
            }
            if (ret.size() < k) {
                ret.add(t);
            } else {
                --remain;
            }
        }
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int[] merge(int[] a, int[] b) {
        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }
        int[] ret = new int[a.length + b.length];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < ret.length; ++i) {
            if (compare(a, p1, b, p2)) {
                ret[i] = a[p1++];
            } else {
                ret[i] = b[p2++];
            }
        }
        return ret;
    }
    // ans的index1开始的子数组，于t从index2开始的子数组比较
    public boolean compare(int[] ans, int index1, int[] t, int index2) {
        while (index1 < ans.length && index2 < t.length) {
            if (ans[index1] < t[index2]) {
                return false;
            }
            if (ans[index1] > t[index2]) {
                return true;
            }
            index1++;
            index2++;
        }
        // 前面元素相同，长的数组认为更大。长的数组后面可能有更大的元素。在两个数组合并时要先把长数组前面的元素用完
        if (index1 < ans.length) {
            return true;
        }
        return false;
    }
}
