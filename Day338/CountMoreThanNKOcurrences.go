package main

import (
	"fmt"
)

// countOccurrence finds all elements in the array that appear more than n/k times.
func countOccurrence(arr []int, n, k int) int {
	count := n / k
	countMap := make(map[int]int)
	answer := 0

	for i := 0; i < n; i++ {
		countMap[arr[i]]++
		if countMap[arr[i]] > count {
			answer++
			countMap[arr[i]] = -1 // Mark as visited
		}
	}

	return answer
}

func main() {
	var t int
	fmt.Scan(&t)

	for t > 0 {
		var n, k int
		fmt.Scan(&n)

		arr := make([]int, n)
		for i := 0; i < n; i++ {
			fmt.Scan(&arr[i])
		}

		fmt.Scan(&k)

		result := countOccurrence(arr, n, k)
		fmt.Println(result)

		t--
	}
}
