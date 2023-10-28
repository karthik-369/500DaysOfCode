package main

import (
	"fmt"
)

func isBleak(n int) int {
	for i := n - 32; i <= n; i++ {
		count := 0
		for j := 0; j < 32; j++ {
			if (1<<j)&i >= 1 {
				count++
			}
		}
		if count+i == n {
			return 0
		}
	}
	return 1
}

func main() {
	var T int
	fmt.Scan(&T)

	for T > 0 {
		var n int
		fmt.Scan(&n)

		ans := isBleak(n)
		fmt.Println(ans)
		T--
	}
}
