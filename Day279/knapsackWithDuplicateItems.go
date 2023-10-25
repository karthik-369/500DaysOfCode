package main

import (
	"fmt"
)

func knapSack(N, W int, val, wt []int) int {
	arr := make([]int, W+1)

	for i := 0; i < N; i++ {
		for j := W; j >= wt[i]; j-- {
			arr[j] = max(arr[j], arr[j-wt[i]]+val[i])
		}
	}

	return arr[W]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var N, W int
		fmt.Scan(&N, &W)

		val := make([]int, N)
		for i := 0; i < N; i++ {
			fmt.Scan(&val[i])
		}

		wt := make([]int, N)
		for i := 0; i < N; i++ {
			fmt.Scan(&wt[i])
		}

		result := knapSack(N, W, val, wt)
		fmt.Println(result)
		t--
	}
}
