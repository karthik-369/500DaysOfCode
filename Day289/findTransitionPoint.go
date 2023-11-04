package main

import (
	"fmt"
)

func transitionPoint(arr []int, n int) int {
	low, high := 0, n-1
	answer := -1

	for low <= high {
		mid := low + (high-low)>>1
		if arr[mid] == 0 {
			low = mid + 1
		} else {
			answer = mid
			high = mid - 1
		}
	}

	return answer
}

func main() {
	var T int
	fmt.Scan(&T)

	for T > 0 {
		var n int
		fmt.Scan(&n)
		arr := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&arr[i])
		}

		result := transitionPoint(arr, n)
		fmt.Println(result)
		T--
	}
}
