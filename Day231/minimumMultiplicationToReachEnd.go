package main

import (
	"fmt"
)

func minimumMultiplications(arr []int, start, end int) int {
	dp := make([]int, 100001)
	for i := 0; i < len(dp); i++ {
		dp[i] = -1
	}

	queue := make([]int, 0)
	queue = append(queue, start)
	dp[start] = 0

	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]

		if curr == end {
			return dp[curr]
		}

		for i := 0; i < len(arr); i++ {
			temp := (curr * arr[i]) % 100000
			if dp[temp] == -1 {
				dp[temp] = dp[curr] + 1
				queue = append(queue, temp)
			}
		}
	}

	return -1
}

func main() {
	arr := []int{2, 3, 5}
	start, end := 2, 10
	result := minimumMultiplications(arr, start, end)
	fmt.Println(result)
}
