package main

import (
	"fmt"
	"sort"
)

func getMinDiff(arr []int, n, k int) int {
	sort.Ints(arr)
	answer := arr[n-1] - arr[0]

	for i := 1; i < n; i++ {
		if arr[i] < k {
			continue
		}

		max := max(arr[i-1]+k, arr[n-1]-k)
		min := min(arr[0]+k, arr[i]-k)
		answer = min(answer, max-min)
	}

	return answer
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	var tc int
	fmt.Scan(&tc)

	for i := 0; i < tc; i++ {
		var k, n int
		fmt.Scan(&k)
		fmt.Scan(&n)

		arr := make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scan(&arr[j])
		}

		ans := getMinDiff(arr, n, k)
		fmt.Println(ans)
	}
}
