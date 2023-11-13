package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	t := parseInt(scanner.Text())

	for i := 0; i < t; i++ {
		scanner.Scan()
		s := scanner.Text()
		str := strings.Fields(s)

		X := str[0]
		Y := str[1]

		obj := Solution{}
		result := obj.shortestCommonSupersequence(X, Y, len(X), len(Y))

		fmt.Println(result)
	}
}

type Solution struct{}

func (s *Solution) shortestCommonSupersequence(X, Y string, m, n int) int {
	arr := make([][]int, m+1)
	for i := range arr {
		arr[i] = make([]int, n+1)
	}

	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if X[i-1] == Y[j-1] {
				arr[i][j] = arr[i-1][j-1] + 1
			} else {
				arr[i][j] = max(arr[i-1][j], arr[i][j-1])
			}
		}
	}

	return m + n - arr[m][n]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func parseInt(s string) int {
	var result int
	fmt.Sscanf(s, "%d", &result)
	return result
}
