// 摩尔投票法的变形。最多有两个数出现频率>(n/3)，因此记录出现频率最大的两个数。
// 之后再次遍历数组，判断这两个数是否出现频率>(n/3)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums[0], m = nums[0], cntN = 0, cntM = 0;
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (i == n) {
                ++cntN;
                continue;
            }
            if (i == m) {
                ++cntM;
                continue;
            }
            // 两个数要不一样，因此一次最多改变其中一个数，改变之后continue
            if (cntN == 0) {
                n = i;
                cntN = 1;
                continue;
            }
            if (cntM == 0) {
                m = i;
                cntM = 1;
                continue;
            }
            --cntM;
            --cntN;
        }
        cntN = 0;
        cntM = 0;
        // 记录这两个数出现次数
        for (int i : nums) {
            if (i == n) {
                ++cntN;
            }
            if (i == m) {
                ++cntM;
            }
        }
        if (cntN > nums.length / 3) {
            res.add(n);
        }
        // 当数组中只有一个数时，m==n，排除这种情况
        if (cntM > nums.length / 3 && m != n) {
            res.add(m);
        }
        return res;
    }
}
