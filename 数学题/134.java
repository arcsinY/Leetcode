// https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/
// 可以推出：若从x可以走到y，但不能走到(y+1)，则x~y之间的任意一个加油站z都不能走到(y+1)
// 因此x走到(y+1)失败时，下次可以直接从(y+1)开始尝试
// 时间复杂度O(n)。暴力解法的复杂度O(n^2)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 0) {
            return -1;
        }
        int start = 0;   // 开始位置
        while (start < n) {
            int cnt = 0;  // 向后走几个加油站
            int sumGas = 0, sumCost = 0;
            while (cnt < n) {
                int j = (start + cnt) % n;  // 尝试走到的加油站
                sumCost += cost[j];  // 需要消耗的
                sumGas += gas[j];   // 能够得到的
                if (sumGas < sumCost) {   // 不能走到j
                    break;
                } else {    // 可以走到j，再往后走一个
                    ++cnt;
                }
            }
            // 判断是由于break退出的循环，还是自退出的循环
            if (cnt == n) {
                return start;
            }
            start = start + cnt + 1;
        }
        return -1;
    }
}
