// 每个气球看作一个区间，两个气球有重叠区间则可以用一箭射爆。问题等价于给定多个区间，寻找有多少个重叠的
func findMinArrowShots(points [][]int) int {
  // 按区间尾排序
	sort.Slice(points, func(i, j int) bool {
		return points[i][1] < points[j][1]
	})
  // 计算重叠情况
	cnt := 1
	end := points[0][1]
	for i := 1; i < len(points); i++ {
    // 一个区间开始在当前末尾后面，说明这个区间和前面的都不重叠
		if points[i][0] >= end {
			cnt++
			end = points[i][1]
		}
	}
	return len(points) - cnt
}
