package main

import (
	"fmt"
)

func snakePattern(matrix [][]int) []int {
	var answer []int
	lr := true
	for i := 0; i < len(matrix); i++ {
		if lr {
			for j := 0; j < len(matrix[0]); j++ {
				answer = append(answer, matrix[i][j])
			}
			lr = false
		} else {
			for j := len(matrix[0]) - 1; j >= 0; j-- {
				answer = append(answer, matrix[i][j])
			}
			lr = true
		}
	}
	return answer
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

		ans := snakePattern(matrix)
		for _, val := range ans {
			fmt.Print(val, " ")
		}
		fmt.Println()
		t--
	}
}
