package main

import (
	"fmt"
)

func sumOfDependencies(adj [][]int, V int) int {
	answer := 0
	for i := 0; i < len(adj); i++ {
		answer += len(adj[i])
	}
	return answer
}

func main() {
	var t, N, M, x, y int
	fmt.Scan(&t)

	for tc := 0; tc < t; tc++ {
		fmt.Scan(&N)
		fmt.Scan(&M)

		adj := make([][]int, N)
		for i := 0; i < N; i++ {
			adj[i] = make([]int, 0)
		}

		for i := 0; i < 2*M; i += 2 {
			fmt.Scan(&x)
			fmt.Scan(&y)
			adj[x] = append(adj[x], y)
		}

		result := sumOfDependencies(adj, N)
		fmt.Println(result)
	}
}
