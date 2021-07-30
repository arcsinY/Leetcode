func titleToNumber(columnTitle string) int {
	ans := 0
	for i := range columnTitle {
		ans = ans * 26 + int(columnTitle[i] - 'A') + 1
	}
	return ans
}
