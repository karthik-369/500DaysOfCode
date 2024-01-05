package main

import (
	"fmt"
)

func diagonal(matrix [][]int, answer []int, visited [][]bool, i, j int) {
	if i < 0 || j < 0 || j >= len(matrix[0]) || i >= len(matrix) || visited[i][j] {
		return
	}
	answer = append(answer, matrix[i][j])
	visited[i][j] = true
	diagonal(matrix, answer, visited, i+1, j-1)
}

func antiDiagonalPattern(matrix [][]int) []int {
	visited := make([][]bool, len(matrix))
	for i := range visited {
		visited[i] = make([]bool, len(matrix[0]))
	}

	answer := make([]int, 0)
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if !visited[i][j] {
				diagonal(matrix, answer, visited, i, j)
			}
		}
	}
	return answer
}

func main() {
	// Example usage:
	matrix := [][]int{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
	}

	result := antiDiagonalPattern(matrix)
	fmt.Println(result)
}
