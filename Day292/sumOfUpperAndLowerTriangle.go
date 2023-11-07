package main

import (
	"fmt"
)

func sumTriangles(matrix [][]int, n int) []int {
	upperSum := 0
	lowerSum := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i <= j {
				upperSum += matrix[i][j]
			}
			if i >= j {
				lowerSum += matrix[i][j]
			}
		}
	}
	return []int{upperSum, lowerSum}
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n int
		fmt.Scan(&n)

		matrix := make([][]int, n)
		for i := 0; i < n; i++ {
			matrix[i] = make([]int, n)
			for j := 0; j < n; j++ {
				fmt.Scan(&matrix[i][j])
			}
		}

		ans := sumTriangles(matrix, n)
		fmt.Println(ans[0], ans[1])
		t--
	}
}
