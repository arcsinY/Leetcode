// 按照以下三条规则生成：
// 1. (randX() - 1) * randY() + randY() 可以均匀生成 [1, X*Y] 的随机数
// 2. randX() 生成 randY()，若 X > Y，则循环调用 randX() 直到返回结果 <= Y 就行了
// 3. randX() 生成 randY()，若 X 是 Y 的倍数，直接 randX() % Y + 1 就可以了
func rand10() int {
    for {
      // 生成 [1, 49] 的随机数，num 相当于 rand49()
        num := (rand7() - 1) * 7 + rand7()
        if num <= 40 {
          // 这时候 num 相当于 rand40()
            return num % 10 + 1
        }
    }
}
