package main

import (
	"fmt"
)

func matrixSum(n, m int, mat [][]int, q int, queries [][]int) []int {
	answer := make([]int, 0)
	for i := 0; i < q; i++ {
		answer = append(answer, find(queries[i][1], queries[i][2], n, m, mat, queries[i][0]))
	}
	return answer
}

func find(i, j, n, m, k int, mat [][]int) int {
	sum := 0
	for t := i - k; t <= i + k; t++ {
		if j >= k && t >= 0 && t < n {
			sum += mat[t][j-k]
		}
	}
	for t := i - k; t <= i + k; t++ {
		if j + k < m && t >= 0 && t < n {
			sum += mat[t][j+k]
		}
	}
	for t := j - k + 1; t <= j + k - 1; t++ {
		if i >= k && t >= 0 && t < m {
			sum += mat[i-k][t]
		}
	}
	for t := j - k + 1; t <= j + k - 1; t++ {
		if i + k < n && t >= 0 && t < m {
			sum += mat[i+k][t]
		}
	}
	return sum
}

func main() {
	var n, m, q int
	fmt.Scan(&n, &m)
	mat := make([][]int, n)
	for i := 0; i < n; i++ {
		mat[i] = make([]int, m)
		for j := 0; j < m; j++ {
			fmt.Scan(&mat[i][j])
		}
	}
	fmt.Scan(&q)
	queries := make([][]int, q)
	for i := 0; i < q; i++ {
		queries[i] = make([]int, 3)
		for j := 0; j < 3; j++ {
			fmt.Scan(&queries[i][j])
		}
	}
	answer := matrixSum(n, m, mat, q, queries)
	for i := 0; i < len(answer); i++ {
		fmt.Print(answer[i], " ")
	}
}
