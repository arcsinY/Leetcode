// 状态压缩dp：用一个变量表示一个状态，状态转移体现为变量的改变。
// 使用state表示一个状态，包含当前所在顶点u，已访问过的顶点mask（访问过的位为1），当前走过的距离dist
type state struct {
    u int
    mask int
    dist int
}

func shortestPathLength(graph [][]int) int {
    n := len(graph)
    q := make([]state, n)
    visit := make([][]bool, n)  // 一个状态是否访问过，用[u][mask]共同确定一个状态
    for i := 0; i < n; i++ {
        visit[i] = make([]bool, 1 << n)
        visit[i][1 << i] = true
        // 开始时所有的状态加入队列
        q = append(q, state{i, 1 << i, 0})
    }
    for len(q) != 0 {
        one := q[0]   // 一个状态one
        q = q[1:]
        if one.mask == 1 << n - 1 {
            return one.dist
        }
        // 转移到下一个状态
        for i := range graph[one.u] {
            v := graph[one.u][i]
            m := one.mask | 1 << v
            if visit[v][m] == false {
                q = append(q, state{v, m, one.dist + 1})
                visit[v][m] = true
            }
        }
    }
    return 0
}
