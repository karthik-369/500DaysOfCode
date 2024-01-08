package main

import (
	"fmt"
	"sort"
)

func solve(arr []int, n int, max int64) int {
	count := 1
	curr := int64(0)

	for _, num := range arr {
		curr += int64(num)
		if curr > max {
			count++
			curr = int64(num)
		}
	}

	return count
}

func splitArray(arr []int, N, K int) int {
	var l, h int64
	for _, num := range arr {
		l = max(l, int64(num))
		h += int64(num)
	}

	for l < h {
		mid := l + (h-l)/2
		temp := solve(arr, N, mid)
		if temp > K {
			l = mid + 1
		} else {
			h = mid
		}
	}

	return int(l)
}

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var N, K int
		fmt.Scan(&N, &K)

		arr := make([]int, N)
		for i := 0; i < N; i++ {
			fmt.Scan(&arr[i])
		}

		res := splitArray(arr, N, K)
		fmt.Println(res)

		t--
	}
}
