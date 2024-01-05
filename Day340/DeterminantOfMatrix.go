package main

import "fmt"

func determinantOfMatrix(matrix [][]int, n int) int {
	if n == 1 {
		return matrix[0][0]
	}

	var ans int

	for i := 0; i < n; i++ {
		second := make([][]int, n-1)
		for j := range second {
			second[j] = make([]int, n-1)
		}

		for j := 1; j < n; j++ {
			x := 0
			for k := 0; k < n; k++ {
				if k == i {
					continue
				}
				second[j-1][x] = matrix[j][k]
				x++
			}
		}

		ans += matrix[0][i] * determinantOfMatrix(second, n-1) * ternary((i&1) == 1, -1, 1)
	}

	return ans
}

func ternary(condition bool, trueVal, falseVal int) int {
	if condition {
		return trueVal
	}
	return falseVal
}

func main() {
	var t int
	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var n int
		fmt.Scan(&n)

		matrix := make([][]int, n)
		for j := range matrix {
			matrix[j] = make([]int, n)
			for k := range matrix[j] {
				fmt.Scan(&matrix[j][k])
			}
		}

		result := determinantOfMatrix(matrix, n)
		fmt.Println(result)
	}
}
