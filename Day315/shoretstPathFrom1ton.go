package main

import (
	"fmt"
)

func minStep(n int) int {
	if n == 1 {
		return 1
	}

	answer := 0
	for n >= 1 {
		answer += (n%3 + 1)
		n /= 3
	}
	return answer - 2
}

func main() {
	var t, n int
	fmt.Scan(&t)

	for tc := 0; tc < t; tc++ {
		fmt.Scan(&n)
		result := minStep(n)
		fmt.Println(result)
	}
}
