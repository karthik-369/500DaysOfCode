package main

import (
	"fmt"
)

// Function to find the maximum sum of subarrays of size K.
func maximumSumSubarray(K int, arr []int, N int) int64 {
	var answer int64 = 0
	var temp int64 = 0
	i, j := 0, 0

	for j < N {
		if j-i+1 <= K {
			temp += int64(arr[j])
			j++
		} else {
			answer = max(answer, temp)
			temp -= int64(arr[i])
			i++
		}
	}

	answer = max(answer, temp)
	return answer
}

// Function to find the maximum of two integers.
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

		// Initializing a slice of size N
		Arr := make([]int, N)

		// Adding elements to the slice
		for i := 0; i < N; i++ {
			fmt.Scan(&Arr[i])
		}

		t--

		// Calling the function maximumSumSubarray
		// and printing the result
		fmt.Println(maximumSumSubarray(K, Arr, N))
	}
}
