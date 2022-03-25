// 每次从列表中任取两个元素，分别做四种运算，将运算结果加入到列表中，递归到下一层
// 为了避免浮点精度问题，将 1e-6 当作 0
// 如果是加、乘运算，两数交换位置不影响结果
// 如果是除法运算，除数不能 == 0
const (
    TARGET = 24
    EPSILON = 1e-6
    ADD, MULTIPLY, SUBTRACT, DIVIDE = 0, 1, 2, 3
)

func judgePoint24(nums []int) bool {
    list := make([]float64, 4)
    for i, num := range nums {
        list[i] = float64(num)
    }
    return solve(list)
}

func solve(list []float64) bool {
    if len(list) == 0 {
        return false
    }
    if len(list) == 1 {
        return abs(list[0] - TARGET) < EPSILON
    }
    size := len(list)
    for i := 0; i < size; i++ {
        for j := 0; j < size; j++ {
            if i == j {
                continue
            }
            // 运算后的数字列表
            list2 := make([]float64, 0)
            for k := 0; k < size; k++ {
                if k != i && k != j {
                    list2 = append(list2, list[k])
                }
            }
            for k := 0; k < 4; k++ {
                // 加法、乘法，要求 i > j，不考虑交换位置
                if k < 2 && i < j {
                    continue
                }
                switch k {
                case ADD:
                    list2 = append(list2, list[i] + list[j])
                case MULTIPLY:
                    list2 = append(list2, list[i] * list[j])
                case SUBTRACT:
                    list2 = append(list2, list[i] - list[j])
                case DIVIDE:
                    if abs(list[j]) < EPSILON {
                        continue
                    } else {
                        list2 = append(list2, list[i] / list[j])
                    }
                }
                if solve(list2) {
                    return true
                }
                list2 = list2[:len(list2) - 1]
            }
        }
    }
    return false
}

func abs(x float64) float64 {
    if x < 0 {
        return -x
    }
    return x
}
