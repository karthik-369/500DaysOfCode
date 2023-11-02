package main

import (
	"fmt"
	"math"
)

func minDist(a []int, n, x, y int) int {
	answer := math.MaxInt64
	ind1, ind2 := math.MaxInt64, math.MaxInt64

	for i := 0; i < n; i++ {
		if a[i] == x {
			ind1 = i
			answer = min(answer, abs(ind1-ind2))
		} else if a[i] == y {
			ind2 = i
			answer = min(answer, abs(ind1-ind2))
		}
	}

	if answer > 1e5 {
		return -1
	}
	return answer
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n, x, y int
		fmt.Scan(&n)
		a := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&a[i])
		}
		fmt.Scan(&x, &y)

		result := minDist(a, n, x, y)
		fmt.Println(result)
		t--
	}
}
