// 暴力解法复杂度O(n^2)，不行
// 剪枝策略：当i走不到j时，i之后的点也走不到j，因此下一次尝试的起点直接设置为j
// 证明：假设油量为have，i 走到 j 时have < 0，说明从 i 走到 (i+1)~(j-1) 之间的位置have > 0。若设置 (i+1)~(j-1) 之间的某一位置做起点，这个位置上的have == 0，更不可能走到 j
func canCompleteCircuit(gas []int, cost []int) int {
	sum := 0
	for i := range gas {
		sum += gas[i] - cost[i]
	}
	if sum < 0 {
		return -1
	}
  // 起点是0
	have := gas[0]
	start := 0
	for i := 1; i < len(gas); i++ {
		have -= cost[i - 1]
    // 走不到 i
		if have < 0 {
			start = i   // 起点设为 i
			have = gas[i]
		} else {  // 获得位置 i 的油
			have += gas[i]
		}
	}
	if start < len(gas) {
		return start
	}
	return -1
}
